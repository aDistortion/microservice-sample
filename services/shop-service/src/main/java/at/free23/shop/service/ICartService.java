/**
 *
 */
package at.free23.shop.service;

import at.free23.shop.api.client.ItemDto;
import at.free23.shop.model.Cart;

/**
 * @author michael.vlasaty
 *
 */
public interface ICartService {

	public Cart fetchCart(String tenantId);

	public Cart addItem(String tenantId, ItemDto itemDto);

	public Cart removeItem(String tenantId, ItemDto itemDto);

	public String checkOutCart(String tenantId);
}
