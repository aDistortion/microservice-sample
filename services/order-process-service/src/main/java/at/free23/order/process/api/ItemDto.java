/**
 *
 */
package at.free23.order.process.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author michael.vlasaty
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ItemDto {

	private String uuid;

	@JsonProperty("quantity")
	private Integer amount;

	private Double netAmount;

	public ItemDto() {

	}

	public ItemDto(OrderItem orderItem) {
		this.uuid = orderItem.getUuid();
		this.amount = orderItem.getQuantity();
		this.netAmount = orderItem.getNetAmount();
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the netAmount
	 */
	public Double getNetAmount() {
		return this.netAmount;
	}

	/**
	 * @param netAmount
	 *            the netAmount to set
	 */
	public void setNetAmount(Double netAmount) {
		this.netAmount = netAmount;
	}

}
