/**
 *
 */
package at.free23.billing.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class Invoice {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pidgen")
	@SequenceGenerator(name = "pidgen", sequenceName = "payment_id_sequence", allocationSize = 1, initialValue = 1)
	private Long id;

	private String orderRef;
	private LocalDateTime recieved;

	private String currency;
	private Double grossTotal;
	private Double netTotal;

	@OneToMany(mappedBy = "invoice", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	private List<Position> positions;

	public Invoice() {

	}

	public Invoice(String orderRef) {
		this.orderRef = orderRef;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRecieved() {
		return this.recieved;
	}

	public void setRecieved(LocalDateTime recieved) {
		this.recieved = recieved;
	}

	public String getOrderRef() {
		return this.orderRef;
	}

	public void setOrderRef(String orderRef) {
		this.orderRef = orderRef;
	}

	public Double getGrossTotal() {
		return this.grossTotal;
	}

	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}

	public Double getNetTotal() {
		return this.netTotal;
	}

	public void setNetTotal(Double netTotal) {
		this.netTotal = netTotal;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
