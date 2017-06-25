/**
 *
 */
package at.free23.order.api;

import java.util.List;

/**
 * @author michael.vlasaty
 *
 */
// @JsonTypeName(value="orderPayload")
public class OrderPayload extends TransactionPayload {

	private List<LineItem> lineItems;

	public OrderPayload(String orderRef, OrderEvent event, List<LineItem> lineItems) {
		this.orderRef = orderRef;
		this.event = event.toString();
		this.lineItems = lineItems;
	}

	public List<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
