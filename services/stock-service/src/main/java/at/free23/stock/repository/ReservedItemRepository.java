/**
 *
 */
package at.free23.stock.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import at.free23.stock.model.ReservedId;
import at.free23.stock.model.ReservedItem;

/**
 * @author michael.vlasaty
 *
 */
@RepositoryRestResource(collectionResourceRel = "reservedItem", path = "reservedItem")
public interface ReservedItemRepository extends PagingAndSortingRepository<ReservedItem, ReservedId> {
	public Iterable<ReservedItem> findByIdOrderRef(@Param("orderRef") String orderRef);

	public Iterable<ReservedItem> findByShippingBookedTrue();
}
