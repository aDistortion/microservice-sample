/**
 *
 */
package at.free23.stock.api;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author michael.vlasaty
 *
 */
@Embeddable
public class ReservedId implements Serializable {
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	private Long itemId;
	private Long orderRef;

	public ReservedId() {

	}

	public ReservedId(Long itemId, Long orderRef) {
		super();
		this.itemId = itemId;
		this.orderRef = orderRef;
	}

	public Long getItemId() {
		return this.itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Long getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(Long orderRef) {
		this.orderRef = orderRef;
	}

	@Override
	public String toString() {
		return this.getOrderRef() + "-" + this.getItemId();
	}

}
