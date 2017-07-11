/**
 *
 */
package at.free23.stock.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.free23.stock.model.StockItem;

/**
 * @author michael.vlasaty
 *
 */
@RepositoryRestResource(collectionResourceRel = "stockItem", path = "stockItem")
public interface StockItemRepository extends PagingAndSortingRepository<StockItem, Long> {

}
