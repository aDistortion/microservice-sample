/**
 *
 */
package at.free23.shipping.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

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
	private Boolean shipped = false;
	private LocalDate expectedArrival;

	@OneToMany(mappedBy = "note", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<ShippingDetail> details;

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

	public LocalDate getExpectedArrival() {
		return this.expectedArrival;
	}

	public void setExpectedArrival(LocalDate expectedArrival) {
		this.expectedArrival = expectedArrival;
	}

	public List<ShippingDetail> getDetails() {
		return this.details;
	}

	public void setDetails(List<ShippingDetail> details) {
		this.details = details;
	}
}
