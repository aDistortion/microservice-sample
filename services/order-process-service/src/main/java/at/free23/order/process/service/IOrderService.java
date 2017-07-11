/**
 *
 */
package at.free23.order.process.service;

import at.free23.order.process.api.Order;

/**
 * @author michael.vlasaty
 *
 */
public interface IOrderService {
	public Order createOrder(Order newOrder);
}
