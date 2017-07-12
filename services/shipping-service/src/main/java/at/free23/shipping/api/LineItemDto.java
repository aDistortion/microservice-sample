/**
 *
 */
package at.free23.shipping.api;

/**
 * @author michael.vlasaty
 *
 */
public class LineItemDto {
	private Long id;
	private Long quantity;
	private String uuid;

	public LineItemDto() {
	}

	public LineItemDto(Long id, Long quantity, String uuid) {
		this.id = id;
		this.quantity = quantity;
		this.uuid = uuid;
	}

	public Long getId() {
		return this.id;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setId(Long id) {
		this.id = id;
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
