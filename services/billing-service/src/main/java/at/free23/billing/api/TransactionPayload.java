/**
 *
 */
package at.free23.billing.api;

/**
 * @author michael.vlasaty
 *
 */
// @JsonTypeInfo(
// use = JsonTypeInfo.Id.NAME,
// include = As.PROPERTY,
// property = "type")
// @JsonSubTypes({
// @JsonSubTypes.Type(value = OrderPayload.class, name = "orderPayload"),
// @JsonSubTypes.Type(value = LineItemPayload.class, name = "lineItemPayload")
// })
public class TransactionPayload {

	protected String orderRef;
	protected String event;

	public String getOrderRef() {
		return this.orderRef;
	}
	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}
	public String getEvent() {
		return this.event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
