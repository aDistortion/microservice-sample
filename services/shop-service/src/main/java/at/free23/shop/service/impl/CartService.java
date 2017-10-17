/**
 *
 */
package at.free23.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

import at.free23.shop.api.client.ItemDto;
import at.free23.shop.api.msg.CartAction;
import at.free23.shop.api.msg.CartActionType;
import at.free23.shop.api.msg.OrderItem;
import at.free23.shop.model.Cart;
import at.free23.shop.model.Item;
import at.free23.shop.repository.CartRepository;
import at.free23.shop.service.ICartService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class CartService implements ICartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private ItemService itemService;

	@Autowired
	private KafkaTemplate<String, ?> kafkaTempalte;

	@Value("${check-out.url}")
	private String checkOutUrl;

	@Override
	public Cart fetchCart(String tenantId) {
		Cart cart = this.cartRepo.findByTenantId(tenantId);
		if (cart == null) {
			cart = this.cartRepo.save(new Cart(tenantId));
		}
		return cart;
	}

	/**
	 * Adds the given amount of an item to the cart. Updates the amount if an
	 * item already exists.
	 *
	 * @param tenantId
	 * @param itemDto
	 * @return the new cart
	 */
	@Override
	public Cart addItem(String tenantId, ItemDto itemDto) {
		final Cart cart = this.fetchCart(tenantId);
		final Item item = this.itemService.addItem(cart, itemDto.getUuid(), itemDto.getAmount());
		this.setOrReplaceItem(cart, item);
		return cart;
	}

	@Override
	public Cart removeItem(String tenantId, ItemDto itemDto) {
		final Cart cart = this.fetchCart(tenantId);
		final Optional<Item> optItem = this.itemService.removeItem(cart, itemDto.getUuid(), itemDto.getAmount());
		if (optItem.isPresent()) {
			this.setOrReplaceItem(cart, optItem.get());
		} else {
			cart.getItems().removeIf(i -> i.getProduct().getUuid().equals(itemDto.getUuid()));
			this.cartRepo.save(cart);
		}
		return cart;
	}

	private void setOrReplaceItem(Cart cart, Item item) {
		final int idx = cart.getItems().indexOf(item);
		if (idx == -1) {
			cart.getItems().add(item);
		} else {
			cart.getItems().set(idx, item);
		}
	}

	/**
	 * A {@code checkOutId} will be generated and sent as message to some
	 * process-engine along with the {@code tenantId}. The {@code checkOutId}
	 * will be returned as relative URL for the client to fetch process state.
	 *
	 * @param tenantId
	 * @return
	 */
	@Override
	public String checkOutCart(String tenantId) {

		final Cart cart = this.fetchCart(tenantId);
		final List<OrderItem> orderItems = this.itemService.fetchOrderItems(cart.getId());
		final CartAction action = this.createCheckOutAction(orderItems, cart.getId(), tenantId);

		this.kafkaTempalte.send(new GenericMessage<>(action));
		this.cartRepo.delete(cart.getId());

		return this.buildUrl(action.getCheckOutId());
	}

	private CartAction createCheckOutAction(List<OrderItem> orderItems, Long cartId, String tenantId) {
		final String checkOutId = cartId.toString() + "-" + String.valueOf(LocalDateTime.now().getMillisOfDay());
		return new CartAction(orderItems, CartActionType.CHECK_OUT, checkOutId, tenantId);
	}

	private String buildUrl(String checkOutId) {
		String url;
		if (this.checkOutUrl.endsWith("/")) {
			url = this.checkOutUrl + checkOutId;
		} else {
			url = this.checkOutUrl + "/" + checkOutId;
		}
		return url;
	}
}
