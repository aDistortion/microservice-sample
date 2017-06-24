/**
 *
 */
package at.free23.order.process.api;

/**
 * @author michael.vlasaty
 *
 */
public enum OrderEvent {
	ORDER_RCV, PAYMENT_RCV, SHIPPING_BOOKED, PAYMENT_OVERDUE, ITEM_WONT_SHIP, SHIPPING_DELAYED;
}
