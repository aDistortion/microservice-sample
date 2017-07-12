/**
 *
 */
package at.free23.shipping.initializer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.free23.shipping.model.StockItem;
import at.free23.shipping.repository.StockItemRepository;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class StockItemInitializer {

	@Autowired
	private StockItemRepository repo;

	@PostConstruct
	public void init() {
		this.repo.save(new StockItem("Indian Pale Ale", "indian-pale-ale"));
		this.repo.save(new StockItem("Craft Beer", "craft-beer"));
		this.repo.save(new StockItem("Beer", "beer"));
	}
}
