/**
 *
 */
package at.free23.order.process.api;

/**
 * @author michael.vlasaty
 *
 */
public enum OrderEvent {
	PAYMENT_RCV, SHIPPING_BOOKED, PAYMENT_OVERDUE, ITEM_WONT_SHIP, SHIPPING_DELAYED, ORDER_COMPLETE, PAYMENT_READY;
}
