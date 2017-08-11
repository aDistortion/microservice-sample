/**
 *
 */
package at.free23.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.shop.api.ItemDto;
import at.free23.shop.model.Cart;
import at.free23.shop.model.Item;
import at.free23.shop.repository.CartRepository;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class CartService {

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private ItemService itemService;

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
	public Cart addItem(String tenantId, ItemDto itemDto) {
		final Cart cart = this.fetchCart(tenantId);
		final Item item = this.itemService.addItem(cart, itemDto.getUuid(), itemDto.getAmount());
		this.setOrReplaceItem(cart, item);
		return cart;
	}

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
}
