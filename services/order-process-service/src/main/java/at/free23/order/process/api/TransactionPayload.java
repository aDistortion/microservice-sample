/**
 *
 */
package at.free23.order.process.api;

/**
 * @author michael.vlasaty
 *
 */
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
