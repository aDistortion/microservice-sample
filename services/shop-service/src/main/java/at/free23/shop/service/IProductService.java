/**
 *
 */
package at.free23.shop.service;

import java.util.List;

import at.free23.shop.api.client.ProductDto;
import at.free23.shop.model.Product;

/**
 * @author michael.vlasaty
 *
 */
public interface IProductService {

	public Product fetchProduct(String uuid);

	public List<ProductDto> fetchProductList();
}
