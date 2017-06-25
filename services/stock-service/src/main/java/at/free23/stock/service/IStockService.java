/**
 *
 */
package at.free23.stock.service;

/**
 * @author michael.vlasaty
 *
 */
public interface IStockService {
	public void reserveItem(String orderRef, Long itemId, Long quantity);

	public void bookShipping(String orderRef);
}
