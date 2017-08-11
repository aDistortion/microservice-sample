/**
 *
 */
package at.free23.shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shop.model.Item;
import at.free23.shop.model.ItemId;

/**
 * @author michael.vlasaty
 *
 */
public interface ItemRepository extends PagingAndSortingRepository<Item, ItemId> {

}
