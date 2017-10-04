/**
 *
 */
package at.free23.shop.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import at.free23.shop.api.ItemDto;
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

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate template;

	private static final String STOCK_INSTANCE_ID = "stock-service";

	@RequestMapping("/")
	public List<ProductDto> getProductListing() {
		final List<Product> products = (List<Product>) this.productRepo.findAll();
		final List<ProductDto> productDto = this.joinProductsWithStock(products);
		return productDto;
	}

	private String getStockServiceUri() {
		return this.discoveryClient.getInstances(STOCK_INSTANCE_ID).get(0).getUri().toString();
	}

	private List<ProductDto> joinProductsWithStock(List<Product> products) {
		return products.stream().map(p -> new ProductDto(p)).map(p -> {
			try {
				final ItemDto stockItem = this.template
						.getForObject(this.getStockServiceUri() + "/stockItem/" + p.getUuid(),
								ItemDto.class);
				p.setOnStock(stockItem.getAmount());
			} catch (final Exception e) {
				// ignore
			}
			return p;
		}).collect(Collectors.toList());
	}
}
