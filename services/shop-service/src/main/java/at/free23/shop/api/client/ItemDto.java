/**
 *
 */
package at.free23.shop.api.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import at.free23.shop.model.Item;

/**
 * @author michael.vlasaty
 *
 *         Client DTO / Message DTO
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class ItemDto {

	private String uuid;

	@JsonProperty("quantity")
	private Integer amount;

	public ItemDto() {

	}

	public ItemDto(Item item) {
		this.uuid = item.getProduct().getUuid();
		this.amount = item.getAmount();
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

}
