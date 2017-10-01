/**
 *
 */
package at.free23.shop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.free23.shop.api.ProductDto;
import at.free23.shop.model.Product;
import at.free23.shop.repository.ProductRepository;

/**
 * @author michael.vlasaty
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepo;

	@RequestMapping("/")
	public List<ProductDto> getProductListing() {
		final List<Product> products = (List<Product>) this.productRepo.findAll();
		final List<ProductDto> productDto = products.stream().map(p -> new ProductDto(p)).collect(Collectors.toList());
		return productDto;
	}
}
