/**
 *
 */
package at.free23.order.api;

/**
 * @author michael.vlasaty
 *
 */
// @JsonTypeName(value="lineItemPayload")
public class LineItemPayload extends TransactionPayload {

	private LineItem item;

	public LineItem getItem() {
		return this.item;
	}

	public void setItem(LineItem item) {
		this.item = item;
	}

}
