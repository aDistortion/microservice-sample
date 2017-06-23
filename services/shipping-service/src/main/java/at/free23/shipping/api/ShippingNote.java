/**
 *
 */
package at.free23.shipping.api;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class ShippingNote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long orderRef;

	private String address;

	private Boolean shipped;

	public ShippingNote() {

	}

	public ShippingNote(Long orderRef) {
		this.orderRef = orderRef;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(Long orderRef) {
		this.orderRef = orderRef;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getShipped() {
		return shipped;
	}

	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}
}
