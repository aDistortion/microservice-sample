/**
 *
 */
package at.free23.shop.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import at.free23.shop.model.Product;

/**
 * @author michael.vlasaty
 *
 */
// FIXME: this one is not used...
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ProductDto {

	private String uuid;
	private String name;
	private String description;
	private String type;
	private String imgUrl;

	private String vendor;
	private String country;

	@JsonProperty("price")
	private Double netAmount;

	@JsonProperty("stock")
	private Integer onStock;

	private Long taxRate;

	public ProductDto() {

	}

	public ProductDto(Product product) {
		this.uuid = product.getUuid();
		this.name = product.getName();
		this.description = product.getDescription();
		this.type = product.getType();
		this.imgUrl = product.getImgUrl();
		this.netAmount = product.getNetAmount();
		this.taxRate = product.getTaxRate();
		this.vendor = product.getVendor().getName();
		this.country = product.getVendor().getCountry();
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

	/**
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return this.vendor;
	}

	/**
	 * @param vendor
	 *            the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the onStock
	 */
	public Integer getOnStock() {
		return this.onStock;
	}

	/**
	 * @param onStock
	 *            the onStock to set
	 */
	public void setOnStock(Integer onStock) {
		this.onStock = onStock;
	}
}
