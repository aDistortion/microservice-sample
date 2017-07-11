/**
 *
 */
package at.free23.order.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.free23.order.model.LineItem;

/**
 * @author michael.vlasaty
 *
 */
@RepositoryRestResource(collectionResourceRel = "lineItem", path = "lineItem")
public interface LineItemRepository extends PagingAndSortingRepository<LineItem, Long> {

}
