/**
 *
 */
package at.free23.order.api;

import java.util.List;

/**
 * @author michael.vlasaty
 *
 */
public class OrderDto {

	private String orderRef;
	private String tenantId;
	private List<LineItemDto> lineItems;

	private boolean paymentRecieved;

	public OrderDto() {

	}

	public OrderDto(String orderRef, List<LineItemDto> items) {
		this.orderRef = orderRef;
		this.lineItems = items;
	}

	public String getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public List<LineItemDto> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItemDto> lineItems) {
		this.lineItems = lineItems;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return this.tenantId;
	}

	/**
	 * @param tenantId
	 *            the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the paymentRecieved
	 */
	public boolean isPaymentRecieved() {
		return this.paymentRecieved;
	}

	/**
	 * @param paymentRecieved
	 *            the paymentRecieved to set
	 */
	public void setPaymentRecieved(boolean paymentRecieved) {
		this.paymentRecieved = paymentRecieved;
	}
}
