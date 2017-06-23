/**
 * 
 */
package at.free23.billing.api;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pidgen")
    @SequenceGenerator(name = "pidgen", sequenceName = "payment_id_sequence", allocationSize = 1, initialValue = 1)
	private Long id;
	
	private Long orderId;
	private LocalDateTime recieved;
	
	private Double grossTotal;
	private Double netTotal;
	private Long taxRate;
	private String currency;
	
	@OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<LineItem> lineItems;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRecieved() {
		return recieved;
	}

	public void setRecieved(LocalDateTime recieved) {
		this.recieved = recieved;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Double getGrossTotal() {
		return grossTotal;
	}

	public void setGrossTotal(Double grossTotal) {
		this.grossTotal = grossTotal;
	}

	public Double getNetTotal() {
		return netTotal;
	}

	public void setNetTotal(Double netTotal) {
		this.netTotal = netTotal;
	}

	public Long getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public List<LineItem> getLineItems() {
		return lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	@Override
	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}
