/**
 *
 */
package at.free23.stock.api;

import java.util.List;

/**
 * @author michael.vlasaty
 *
 */
public class OrderPayload extends TransactionPayload {

	private List<LineItem> lineItems;

	public OrderPayload() {
	}

	public OrderPayload(String orderRef, OrderEvent event) {
		this.orderRef = orderRef;
		this.event = event.toString();
	}

	public List<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
