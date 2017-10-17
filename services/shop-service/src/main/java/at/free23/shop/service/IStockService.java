/**
 *
 */
package at.free23.shop.service;

import at.free23.shop.api.client.ItemDto;

/**
 * @author michael.vlasaty
 *
 */
public interface IStockService {

	public ItemDto fetchStockItem(String uuid);
}
