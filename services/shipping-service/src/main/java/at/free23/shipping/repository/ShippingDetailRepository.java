/**
 *
 */
package at.free23.shipping.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shipping.model.ShippingDetail;
import at.free23.shipping.model.ShippingDetailId;

/**
 * @author michael.vlasaty
 *
 */
public interface ShippingDetailRepository extends PagingAndSortingRepository<ShippingDetail, ShippingDetailId> {

}
