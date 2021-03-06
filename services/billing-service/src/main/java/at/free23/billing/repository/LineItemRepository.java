/**
 *
 */
package at.free23.billing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.billing.model.LineItem;

/**
 * @author michael.vlasaty
 *
 */
public interface LineItemRepository extends PagingAndSortingRepository<LineItem, Long> {

	public LineItem findByUuid(String uuid);
}
