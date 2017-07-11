/**
 *
 */
package at.free23.billing.api;

/**
 * @author michael.vlasaty
 *
 */
public class LineItemDto {
	private Long quantity;
	private String uuid;

	public LineItemDto() {
	}

	public LineItemDto(Long quantity) {
		this.quantity = quantity;
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
