/**
 *
 */
package at.free23.order.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author michael.vlasaty
 *
 */
@Embeddable
public class OrderLineItemId implements Serializable {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	private Long orderId;

	private Long lineItemId;

	public OrderLineItemId() {
	}

	public OrderLineItemId(Long orderId, Long lineItemId) {
		this.orderId = orderId;
		this.lineItemId = lineItemId;
	}

	public OrderLineItemId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderId() {
		return this.orderId;
	}

	public Long getLineItemId() {
		return this.lineItemId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final OrderLineItemId that = (OrderLineItemId) o;
		return Objects.equals(this.getOrderId(), that.getOrderId())
				&& Objects.equals(this.getLineItemId(), that.getLineItemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getOrderId(), this.getLineItemId());
	}

	@Override
	public String toString() {
		return this.getOrderId() + "-" + this.getLineItemId();
	}
}
