/**
 *
 */
package at.free23.stock.api;

/**
 * @author michael.vlasaty
 *
 */
public class ShippingPayload extends TransactionPayload {

	private Double timeAmount;

	public ShippingPayload() {

	}

	public ShippingPayload(String orderRef, ShippingEvent event, Double timeAmount) {
		this.orderRef = orderRef;
		this.event = event.toString();
		this.timeAmount = timeAmount;
	}

	public Double getTimeAmount() {
		return this.timeAmount;
	}

	public void setTimeAmount(Double timeAmount) {
		this.timeAmount = timeAmount;
	}

}
