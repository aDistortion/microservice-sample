/**
 *
 */
package at.free23.shipping.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author michael.vlasaty
 *
 */
@Embeddable
public class ShippingDetailId implements Serializable {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	private Long noteId;
	private Long itemId;

	public ShippingDetailId() {

	}

	public ShippingDetailId(Long noteId, Long itemId) {
		super();
		this.noteId = noteId;
		this.itemId = itemId;
	}

	public Long getNoteId() {
		return this.noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final ShippingDetailId that = (ShippingDetailId) o;
		return Objects.equals(this.getNoteId(), that.getNoteId()) && Objects.equals(this.getItemId(), that.getItemId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getNoteId(), this.getItemId());
	}

	@Override
	public String toString() {
		return this.getNoteId() + "-" + this.getItemId();
	}
}
