/**
 *
 */
package at.free23.order.api;

/**
 * @author michael.vlasaty
 *
 */
public class LineItemDto {

	private String uuid;
	private Integer quantity;
	private Double netAmount;

	public LineItemDto() {
	}

	public LineItemDto(String uuid, Integer quantity) {
		this.uuid = uuid;
		this.quantity = quantity;
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
