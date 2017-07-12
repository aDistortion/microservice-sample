/**
 *
 */
package at.free23.shipping.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shipping.model.StockItem;

/**
 * @author michael.vlasaty
 *
 */
public interface StockItemRepository extends PagingAndSortingRepository<StockItem, Long> {
	public StockItem findByUuid(String uuid);
}
