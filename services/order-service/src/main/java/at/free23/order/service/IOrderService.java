/**
 *
 */
package at.free23.order.service;

import at.free23.order.model.Order;

/**
 * @author michael.vlasaty
 *
 */
public interface IOrderService {

	public Order createOrder(Order newOrder);

	public Order addItem(Long orderId, Long lineItemId);

	public void removeItem(Long orderId, Long lineItemId);
}
