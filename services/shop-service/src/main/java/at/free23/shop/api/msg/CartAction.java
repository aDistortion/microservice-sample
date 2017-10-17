/**
 *
 */
package at.free23.shop.api.msg;

import java.util.List;

/**
 * @author michael.vlasaty
 *
 *         Message DTO
 */
public class CartAction {

	private CartActionType type;
	private List<OrderItem> orderItems;
	private String checkOutId;
	private String tenantId;

	public CartAction() {

	}

	public CartAction(List<OrderItem> orderItems, CartActionType type, String checkOutId, String tenantId) {
		this.orderItems = orderItems;
		this.type = type;
		this.checkOutId = checkOutId;
		this.tenantId = tenantId;
	}

	/**
	 * @return the type
	 */
	public CartActionType getType() {
		return this.type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(CartActionType type) {
		this.type = type;
	}

	/**
	 * @return the tenantId
	 */
	public String getTenantId() {
		return this.tenantId;
	}

	/**
	 * @param tenantId
	 *            the tenantId to set
	 */
	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	/**
	 * @return the checkOutId
	 */
	public String getCheckOutId() {
		return this.checkOutId;
	}

	/**
	 * @param checkOutId
	 *            the checkOutId to set
	 */
	public void setCheckOutId(String checkOutId) {
		this.checkOutId = checkOutId;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return this.orderItems;
	}

	/**
	 * @param orderItems
	 *            the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
