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

	private String orderRef;

	private String address;

	private Boolean shipped;

	public ShippingNote() {

	}

	public ShippingNote(String orderRef) {
		this.orderRef = orderRef;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Boolean getShipped() {
		return this.shipped;
	}

	public void setShipped(Boolean shipped) {
		this.shipped = shipped;
	}
}
