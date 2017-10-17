/**
 *
 */
package at.free23.shop.service;

import java.util.List;
import java.util.Optional;

import at.free23.shop.api.msg.OrderItem;
import at.free23.shop.model.Cart;
import at.free23.shop.model.Item;

/**
 * @author michael.vlasaty
 *
 */
public interface IItemService {

	public Optional<Item> removeItem(Cart cart, String uuid, Integer amount);

	public Item addItem(Cart cart, String uuid, Integer amount);

	public Item fetchItem(Long cartId, Long productId);

	public List<OrderItem> fetchOrderItems(Long cartId);

}
