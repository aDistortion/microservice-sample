/**
 *
 */
package at.free23.order.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.free23.order.model.OrderLineItem;
import at.free23.order.model.OrderLineItemId;

/**
 * @author michael.vlasaty
 *
 */
@RepositoryRestResource(collectionResourceRel = "orderLineItems", path = "orderLineItems")
public interface OrderLineItemsRepository extends PagingAndSortingRepository<OrderLineItem, OrderLineItemId> {

}
