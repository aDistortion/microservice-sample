/**
 *
 */
package at.free23.billing.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author michael.vlasaty
 *
 */
@Entity
@Table(name = "payment_line_items")
public class Position implements Serializable {
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PositionId id;

	@JsonIgnore
	@ManyToOne
	@MapsId("invoiceId")
	private Invoice invoice;

	@JsonIgnore
	@ManyToOne
	@MapsId("lineItemId")
	private LineItem lineItem;

	private Long quantity;
	private Double total;

	public Position() {

	}

	public Position(LineItem item, Long quantity) {
		this.lineItem = item;
		this.quantity = quantity;
	}

	public PositionId getId() {
		return this.id;
	}

	public void setId(PositionId id) {
		this.id = id;
	}

	public Invoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
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

	public Double getTotal() {
		return this.total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final Position that = (Position) o;
		return Objects.equals(this.getInvoice(), that.getInvoice())
				&& Objects.equals(this.getLineItem(), that.getLineItem());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getInvoice(), this.getLineItem());
	}
}
