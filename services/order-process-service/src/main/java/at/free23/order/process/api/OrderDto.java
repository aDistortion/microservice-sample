package at.free23.order.process.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

	private String id;
	private String orderRef;

	private String tenantId;
	private List<ItemDto> lineItems;

	private boolean paymentRecieved;

	public OrderDto() {

	}

	public OrderDto(String tenantId, List<ItemDto> lineItems) {
		this.tenantId = tenantId;
		this.lineItems = lineItems;
		this.paymentRecieved = false;
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<ItemDto> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<ItemDto> lineItems) {
		this.lineItems = lineItems;
	}

	public boolean isPaymentRecieved() {
		return this.paymentRecieved;
	}

	public void setPaymentRecieved(boolean paymentRecieved) {
		this.paymentRecieved = paymentRecieved;
	}

	public String getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
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

}
