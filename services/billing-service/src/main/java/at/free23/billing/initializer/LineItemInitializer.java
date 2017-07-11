/**
 *
 */
package at.free23.billing.initializer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.free23.billing.model.LineItem;
import at.free23.billing.repository.LineItemRepository;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class LineItemInitializer {

	@Autowired
	private LineItemRepository repo;

	@PostConstruct
	public void init() {
		this.repo.save(new LineItem("Indian Pale Ale", "indian-pale-ale", 7D, 20L, "EUR"));
		this.repo.save(new LineItem("Craft Beer", "craft-beer", 4D, 20L, "EUR"));
		this.repo.save(new LineItem("Beer", "beer", 2.5D, 20L, "EUR"));
	}
}
