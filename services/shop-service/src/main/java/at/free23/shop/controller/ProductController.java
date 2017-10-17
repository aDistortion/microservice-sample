/**
 *
 */
package at.free23.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.free23.shop.api.client.ProductDto;
import at.free23.shop.service.IProductService;

/**
 * @author michael.vlasaty
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/")
	public List<ProductDto> getProductListing() {
		return this.productService.fetchProductList();
	}

}
