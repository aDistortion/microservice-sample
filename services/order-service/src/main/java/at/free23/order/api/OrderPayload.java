/**
 * 
 */
package at.free23.order.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * @author michael.vlasaty
 *
 */
@JsonTypeName(value="orderPayload")
public class OrderPayload extends TransactionPayload {

	private List<LineItem> lineItems;

	public OrderPayload(Long orderRef, String event, List<LineItem> lineItems){
		this.orderRef = orderRef;
		this.event = event;
		this.lineItems = lineItems;
	}
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
}
