/**
 *
 */
package at.free23.shipping.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shipping.model.ShippingNote;

/**
 * @author michael.vlasaty
 *
 */
public interface ShippingNoteRepository extends PagingAndSortingRepository<ShippingNote, Long> {
	public ShippingNote findByOrderRef(String orderRef);
}
