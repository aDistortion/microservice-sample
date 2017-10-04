/**
 *
 */
package at.free23.stock.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class ReservedItem {

	@EmbeddedId
	private ReservedId id;

	private Integer amount;

	private boolean shippingBooked = false;

	public ReservedItem() {
	}

	public ReservedItem(Long itemId, String orderRef, Integer amount) {
		this.id = new ReservedId(itemId, orderRef);
		this.amount = amount;
	}

	public ReservedId getId() {
		return this.id;
	}

	public void setId(ReservedId id) {
		this.id = id;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public boolean isShippingBooked() {
		return this.shippingBooked;
	}

	public void setShippingBooked(boolean shippingBooked) {
		this.shippingBooked = shippingBooked;
	}
}
