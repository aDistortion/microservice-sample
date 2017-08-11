/**
 *
 */
package at.free23.shop.api;

import at.free23.shop.model.Item;

/**
 * @author michael.vlasaty
 *
 */
public class ItemDto {

	private String uuid;
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
