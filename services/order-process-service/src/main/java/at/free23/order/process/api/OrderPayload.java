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

	private List<LineItemDto> lineItems;

	public List<LineItemDto> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItemDto> lineItems) {
		this.lineItems = lineItems;
	}
}
