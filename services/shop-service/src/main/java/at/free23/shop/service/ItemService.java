/**
 *
 */
package at.free23.shop.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.shop.model.Cart;
import at.free23.shop.model.Item;
import at.free23.shop.model.ItemId;
import at.free23.shop.model.Product;
import at.free23.shop.repository.ItemRepository;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepo;

	@Autowired
	private ProductService productService;

	public Optional<Item> removeItem(Cart cart, String uuid, Integer amount) {
		final Product product = this.productService.fetchProduct(uuid);
		final Item item = this.fetchItem(cart.getId(), product.getId());
		item.setAmount(item.getAmount() - amount);
		if (item.getAmount() < 1) {
			return Optional.empty();
		} else {
			return Optional.of(this.itemRepo.save(item));
		}
	}

	public Item addItem(Cart cart, String uuid, Integer amount) {
		final Product product = this.productService.fetchProduct(uuid);
		Item item = this.fetchItem(cart.getId(), product.getId());
		if (item == null) {
			item = new Item(cart, product);
		}
		item.setAmount(item.getAmount() + amount);
		return this.itemRepo.save(item);
	}

	public Item fetchItem(Long cartId, Long productId) {
		return this.fetchItem(new ItemId(cartId, productId));
	}

	private Item fetchItem(ItemId id) {
		return this.itemRepo.findOne(id);
	}

}
