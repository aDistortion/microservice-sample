/**
 * 
 */
package at.free23.order.api;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author michael.vlasaty
 *
 */
@JsonTypeName(value="lineItemPayload")
public class LineItemPayload extends TransactionPayload {

	private LineItem item;

	public LineItem getItem() {
		return item;
	}

	public void setItem(LineItem item) {
		this.item = item;
	}
	
}
