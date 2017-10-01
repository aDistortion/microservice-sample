/**
 *
 */
package at.free23.shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shop.model.Vendor;

/**
 * @author michael.vlasaty
 *
 */
public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long> {

}
