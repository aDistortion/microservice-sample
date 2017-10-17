/**
 *
 */
package at.free23.shop.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.shop.api.msg.OrderItem;
import at.free23.shop.model.Cart;
import at.free23.shop.model.Item;
import at.free23.shop.model.ItemId;
import at.free23.shop.model.Product;
import at.free23.shop.repository.ItemRepository;
import at.free23.shop.service.IItemService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class ItemService implements IItemService {
	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private ProductService productService;

	@Override
	public Optional<Item> removeItem(Cart cart, String uuid, Integer amount) {
		final Product product = this.productService.fetchProduct(uuid);
		final Item item = this.fetchItem(cart.getId(), product.getId());
		item.setAmount(item.getAmount() - amount);
		if (item.getAmount() < 1) {
			this.itemRepo.delete(item);
			return Optional.empty();
		} else {
			return Optional.of(this.itemRepo.save(item));
		}
	}

	@Override
	public Item addItem(Cart cart, String uuid, Integer amount) {
		final Product product = this.productService.fetchProduct(uuid);
		Item item = this.fetchItem(cart.getId(), product.getId());
		if (item == null) {
			item = new Item(cart, product);
		}
		item.setAmount(item.getAmount() + amount);
		return this.itemRepo.save(item);
	}

	@Override
	public Item fetchItem(Long cartId, Long productId) {
		return this.fetchItem(new ItemId(cartId, productId));
	}

	private Item fetchItem(ItemId id) {
		return this.itemRepo.findOne(id);
	}

	@Override
	public List<OrderItem> fetchOrderItems(Long cartId) {
		return this.itemRepo.findOrderItemsByCartId(cartId);
	}

}
