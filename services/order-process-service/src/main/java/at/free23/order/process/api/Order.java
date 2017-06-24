package at.free23.order.process.api;

import java.util.List;

public class Order {

	private Long id;
	
	private List<LineItem> lineItems;

	private boolean paymentRecieved = false;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public boolean isPaymentRecieved() {
		return this.paymentRecieved;
	}

	public void setPaymentRecieved(boolean paymentRecieved) {
		this.paymentRecieved = paymentRecieved;
	}
}
