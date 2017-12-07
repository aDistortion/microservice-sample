/**
 *
 */
package at.free23.stock.service;

/**
 * @author michael.vlasaty
 *
 */
public interface IStockService {

	public void bookShipping(String orderRef);

	public void cancelReservedItems(String orderRef);

	public Double reserveItem(String orderRef, String uuid, Integer quantity);
}
