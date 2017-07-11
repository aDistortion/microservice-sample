/**
 *
 */
package at.free23.billing.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author michael.vlasaty
 *
 */
@Embeddable
public class PositionId implements Serializable {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	private Long invoiceId;
	private Long lineItemId;

	public PositionId() {

	}

	public PositionId(Long invoiceId, Long lineItemId) {
		super();
		this.invoiceId = invoiceId;
		this.lineItemId = lineItemId;
	}

	public Long getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}

	public Long getLineItemId() {
		return this.lineItemId;
	}

	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final PositionId that = (PositionId) o;
		return Objects.equals(this.getInvoiceId(), that.getInvoiceId())
				&& Objects.equals(this.getLineItemId(), that.getLineItemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getInvoiceId(), this.getLineItemId());
	}

	@Override
	public String toString() {
		return this.getInvoiceId() + "-" + this.getLineItemId();
	}
}
