/**
 *
 */
package at.free23.stock.api;

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

	private Long amount;

	public ReservedItem() {
	}

	public ReservedItem(Long itemId, Long orderRef, Long amount) {
		this.id = new ReservedId(itemId, orderRef);
		this.amount = amount;
	}

	public ReservedId getId() {
		return this.id;
	}

	public void setId(ReservedId id) {
		this.id = id;
	}

	public Long getAmount() {
		return this.amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
}
