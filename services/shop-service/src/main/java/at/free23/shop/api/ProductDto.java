/**
 *
 */
package at.free23.shop.api;

import at.free23.shop.model.Product;

/**
 * @author michael.vlasaty
 *
 */
public class ProductDto {

	private String uuid;
	private String name;
	private String description;
	private String imgUrl;

	private Double grossAmount;
	private Double netAmount;

	private Long taxRate;

	public ProductDto() {

	}

	public ProductDto(Product product) {

	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return this.imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Double getGrossAmount() {
		return this.grossAmount;
	}

	public void setGrossAmount(Double grossAmount) {
		this.grossAmount = grossAmount;
	}

	public Double getNetAmount() {
		return this.netAmount;
	}

	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

	public Long getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}
}
