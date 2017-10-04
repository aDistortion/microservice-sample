package at.free23.stock.api;

import at.free23.stock.model.StockItem;

public class LineItemDto {

	private Long id;

	private Integer quantity;

	private String uuid;

	public LineItemDto() {
	}

	public LineItemDto(StockItem item) {
		this.uuid = item.getUuid();
		this.quantity = item.getStored();
	}

	public LineItemDto(Long id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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
