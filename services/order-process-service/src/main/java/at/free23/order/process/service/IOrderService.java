/**
 *
 */
package at.free23.order.process.service;

import java.util.List;

import at.free23.order.process.api.ItemDto;
import at.free23.order.process.api.OrderDto;

/**
 * @author michael.vlasaty
 *
 */
public interface IOrderService {
	public OrderDto createOrder(String tenantId, List<ItemDto> items);
}
