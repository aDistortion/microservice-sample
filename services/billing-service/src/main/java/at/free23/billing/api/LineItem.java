package at.free23.billing.api;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// @JsonTypeName(value="lineItem")
public class LineItem {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long quantity;
	private Double netAmount;
	private Double grossAmount;
	private Long taxRate;
	private String currency;

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Double getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Double getGrossAmount() {
		return this.grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public Long getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

}
