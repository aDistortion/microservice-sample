/**
 *
 */
package at.free23.stock.model;

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
	private String orderRef;

	public ReservedId() {

	}

	public ReservedId(Long itemId, String orderRef) {
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

	public String getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	@Override
	public String toString() {
		return this.getOrderRef() + "-" + this.getItemId();
	}

}
