/**
 *
 */
package at.free23.order.api;

import at.free23.order.model.LineItem;

/**
 * @author michael.vlasaty
 *
 */
public class LineItemPayload extends TransactionPayload {

	private LineItem item;

	public LineItem getItem() {
		return this.item;
	}

	public void setItem(LineItem item) {
		this.item = item;
	}

}
