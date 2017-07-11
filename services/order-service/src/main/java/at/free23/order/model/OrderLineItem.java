/**
 *
 */
package at.free23.order.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author michael.vlasaty
 *
 */
@Entity
@Table(name = "order_line_items")
public class OrderLineItem implements Serializable {
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderLineItemId id;

	@JsonIgnore
	@ManyToOne
	@MapsId("orderId")
	private Order order;

	@JsonIgnore
	@ManyToOne
	@MapsId("lineItemId")
	private LineItem lineItem;

	private Long quantity;

	@SuppressWarnings("unused")
	private OrderLineItem() {
	}

	public OrderLineItem(Order order, LineItem lineItem) {
		this.order = order;
		this.lineItem = lineItem;
		this.id = new OrderLineItemId(order.getOrderId(), lineItem.getLineItemId());
	}

	public OrderLineItemId getId() {
		return this.id;
	}

	public void setId(OrderLineItemId id) {
		this.id = id;
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public LineItem getLineItem() {
		return this.lineItem;
	}

	public void setLineItem(LineItem lineItem) {
		this.lineItem = lineItem;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final OrderLineItem that = (OrderLineItem) o;
		return Objects.equals(this.getOrder(), that.getOrder())
				&& Objects.equals(this.getLineItem(), that.getLineItem());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getOrder(), this.getLineItem());
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
