/**
 *
 */
package at.free23.stock.api;

/**
 * @author michael.vlasaty
 *
 */
public enum OrderEvent {
	ORDER_RCV, PAYMENT_RCV, PAYMENT_OVERDUE, ITEM_WONT_SHIP, SHIPPING_BOOKED, SHIPPING_DELAYED;
}
