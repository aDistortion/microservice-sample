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

	private List<LineItemDto> lineItems;

	public OrderPayload() {
	}

	public OrderPayload(String orderRef, OrderEvent event) {
		this.orderRef = orderRef;
		this.event = event.toString();
	}

	public List<LineItemDto> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItemDto> lineItems) {
		this.lineItems = lineItems;
	}
}
