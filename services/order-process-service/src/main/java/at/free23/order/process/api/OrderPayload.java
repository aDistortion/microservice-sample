/**
 *
 */
package at.free23.order.process.api;

import java.util.List;

/**
 * @author michael.vlasaty
 *
 */
public class OrderPayload extends TransactionPayload {

	private List<LineItem> lineItems;

	public List<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
