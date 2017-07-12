/**
 *
 */
package at.free23.shipping.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class ShippingDetail implements Serializable {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ShippingDetailId id;

	@JsonIgnore
	@ManyToOne
	@MapsId("noteId")
	private ShippingNote note;

	@JsonIgnore
	@ManyToOne
	@MapsId("itemId")
	private StockItem item;

	private Long quantity;

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public ShippingDetailId getId() {
		return this.id;
	}

	public void setId(ShippingDetailId id) {
		this.id = id;
	}

	public ShippingNote getNote() {
		return this.note;
	}

	public void setNote(ShippingNote note) {
		this.note = note;
	}

	public StockItem getItem() {
		return this.item;
	}

	public void setItem(StockItem item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final ShippingDetail that = (ShippingDetail) o;
		return Objects.equals(this.getNote(), that.getNote()) && Objects.equals(this.getItem(), that.getItem());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getNote(), this.getItem());
	}
}
