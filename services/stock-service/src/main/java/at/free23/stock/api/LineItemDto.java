package at.free23.stock.api;

public class LineItemDto {

	private Long id;

	private Long quantity;

	private String uuid;

	public LineItemDto() {
	}

	public LineItemDto(Long id, Long quantity) {
		this.id = id;
		this.quantity = quantity;
	}

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

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
