/**
 * 
 */
package at.free23.billing.api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;

/**
 * @author michael.vlasaty
 *
 */
@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = As.PROPERTY, 
  property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = OrderPayload.class, name = "orderPayload"),
    @JsonSubTypes.Type(value = LineItemPayload.class, name = "lineItemPayload")
})
public class TransactionPayload {

	protected Long orderRef;
	protected String event;
	
	public Long getOrderRef() {
		return orderRef;
	}
	public void setOrderRef(Long orderRef) {
		this.orderRef = orderRef;
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
