package at.free23.billing.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String uuid;
	private String name;

	private Double price;
	private Long taxRate;
	private String currency;

	@OneToMany(mappedBy = "lineItem", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Position> positions;

	public LineItem() {

	}

	public LineItem(String name, String uuid, Double price, Long taxRate, String currency) {
		this.name = name;
		this.uuid = uuid;
		this.price = price;
		this.taxRate = taxRate;
		this.currency = currency;
	}

	// public LineItem calculateNetAmount() {
	// if (this.getTaxRate() != null && this.getGrossAmount() != null) {
	// final Double tax = this.getGrossAmount() * this.getTaxRate() / 100;
	// this.setNetAmount(this.getGrossAmount() - tax);
	// }
	// return this;
	// }

	public LineItem(String uuid) {
		this.uuid = uuid;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
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

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Position> getPositions() {
		return this.positions;
	}

	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
