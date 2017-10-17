/**
 *
 */
package at.free23.shop.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.shop.api.client.ItemDto;
import at.free23.shop.api.client.ProductDto;
import at.free23.shop.exception.ProductNotFoundException;
import at.free23.shop.model.Product;
import at.free23.shop.repository.ProductRepository;
import at.free23.shop.service.IProductService;
import at.free23.shop.service.IStockService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private IStockService stockService;

	@Override
	public Product fetchProduct(String uuid) {
		final Product product = this.productRepo.findByUuid(uuid);
		if (product == null) {
			throw new ProductNotFoundException(uuid);
		}
		return product;
	}

	@Override
	public List<ProductDto> fetchProductList() {
		final List<Product> products = (List<Product>) this.productRepo.findAll();
		final List<ProductDto> productDto = this.joinProductsWithStock(products);
		return productDto;
	}

	private List<ProductDto> joinProductsWithStock(List<Product> products) {
		return products.stream().map(p -> new ProductDto(p)).map(p -> {
			try {
				final ItemDto stockItem = this.stockService.fetchStockItem(p.getUuid());
				p.setOnStock(stockItem.getAmount());
			} catch (final Exception e) {
				// ignore
			}
			return p;
		}).collect(Collectors.toList());
	}

}
