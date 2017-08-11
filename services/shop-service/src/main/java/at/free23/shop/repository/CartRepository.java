/**
 *
 */
package at.free23.shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shop.model.Cart;

/**
 * @author michael.vlasaty
 *
 */
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {
	public Cart findByTenantId(String tenantId);
}
