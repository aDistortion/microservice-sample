/**
 *
 */
package at.free23.stock.service;

/**
 * @author michael.vlasaty
 *
 */
public interface IStockService {
	public void reserveItem(Long orderRef, Long itemId, Long quantity);

	public void bookShipping(Long orderRef);
}
