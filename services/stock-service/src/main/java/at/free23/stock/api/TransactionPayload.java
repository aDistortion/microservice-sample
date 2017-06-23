/**
 * 
 */
package at.free23.stock.api;

/**
 * @author michael.vlasaty
 *
 */
public class TransactionPayload {

	protected Long orderRef;
	protected String event;
	
	public Long getOrderRef() {
		return this.orderRef;
	}
	public void setOrderRef(Long orderRef) {
		this.orderRef = orderRef;
	}
	public String getEvent() {
		return this.event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
}
