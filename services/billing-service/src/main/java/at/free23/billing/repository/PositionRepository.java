/**
 *
 */
package at.free23.billing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.billing.model.Position;
import at.free23.billing.model.PositionId;

/**
 * @author michael.vlasaty
 *
 */
public interface PositionRepository extends PagingAndSortingRepository<Position, PositionId> {
	// public Position findByLineItem_Uuid(String uuid);
}
