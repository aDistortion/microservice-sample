/**
 *
 */
package at.free23.shipping.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shipping.api.LineItem;

/**
 * @author michael.vlasaty
 *
 */
public interface LineItemRepository extends PagingAndSortingRepository<LineItem, Long> {

}
