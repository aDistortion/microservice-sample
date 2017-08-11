/**
 *
 */
package at.free23.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.shop.exception.ProductNotFoundException;
import at.free23.shop.model.Product;
import at.free23.shop.repository.ProductRepository;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;

	public Product fetchProduct(String uuid) {
		final Product product = this.productRepo.findByUuid(uuid);
		if (product == null) {
			throw new ProductNotFoundException(uuid);
		}
		return product;
	}
}
