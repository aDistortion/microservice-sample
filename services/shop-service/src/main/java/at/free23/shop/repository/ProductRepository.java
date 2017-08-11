/**
 *
 */
package at.free23.shop.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.shop.model.Product;

/**
 * @author michael.vlasaty
 *
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

	public Product findByUuid(String uuid);
}
