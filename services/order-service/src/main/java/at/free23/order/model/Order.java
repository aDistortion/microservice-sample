package at.free23.order.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@Entity
@Table(name = "orderEntity") // order is reserved
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@SequenceGenerator(name = "idgen", sequenceName = "order_id_sequence", allocationSize = 1, initialValue = 1)
	private Long orderId;

	private String orderRef;

	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@OrderColumn(name = "positionNo")
	private List<OrderLineItem> orderLineItems;

	private boolean paymentRecieved = false;

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public List<OrderLineItem> getOrderLineItems() {
		return this.orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
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

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
