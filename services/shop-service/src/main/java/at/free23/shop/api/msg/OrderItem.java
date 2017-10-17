/**
 *
 */
package at.free23.shop.api.msg;

import java.time.LocalDateTime;

/**
 * @author michael.vlasaty
 *
 */
public class OrderItem {

	private String uuid;
	private String name;

	private Integer quantity;

	private Double netAmount;

	private LocalDateTime expectedShipping = LocalDateTime.now().plusDays(5L);

	public OrderItem() {

	}

	public OrderItem(String uuid, String name, Integer quantity, Double netAmount) {
		this.uuid = uuid;
		this.name = name;
		this.quantity = quantity;
		this.netAmount = netAmount;
	}
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return this.uuid;
	}

	/**
	 * @param uuid
	 *            the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return this.quantity;
	}

	/**
	 * @param quantity
	 *            the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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

	/**
	 * @return the expectedShipping
	 */
	public LocalDateTime getExpectedShipping() {
		return this.expectedShipping;
	}

	/**
	 * @param expectedShipping
	 *            the expectedShipping to set
	 */
	public void setExpectedShipping(LocalDateTime expectedShipping) {
		this.expectedShipping = expectedShipping;
	}
}
