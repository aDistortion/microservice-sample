package at.free23.stock.api;

import at.free23.stock.model.StockItem;

public class StockItemDto {

	private String uuid;

	private Integer quantity;


	public StockItemDto() {
	}

	public StockItemDto(StockItem item) {
		this.uuid = item.getUuid();
		this.quantity = item.getStored();
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
