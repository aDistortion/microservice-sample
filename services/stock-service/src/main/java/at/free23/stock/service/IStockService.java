/**
 *
 */
package at.free23.stock.service;

/**
 * @author michael.vlasaty
 *
 */
public interface IStockService {
	/**
	 *
	 * @param orderRef
	 * @param itemId
	 * @param quantity
	 * @return preparationTime
	 */
	public Double reserveItem(String orderRef, String uuid, Integer quantity);

	public void bookShipping(String orderRef);

	public void cancelReservedItems(String orderRef);
}
