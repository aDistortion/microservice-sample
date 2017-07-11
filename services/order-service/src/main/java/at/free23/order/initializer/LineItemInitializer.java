/**
 *
 */
package at.free23.order.initializer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.free23.order.model.LineItem;
import at.free23.order.repository.LineItemRepository;

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
		this.repo.save(new LineItem("Indian Pale Ale", "indian-pale-ale"));
		this.repo.save(new LineItem("Craft Beer", "craft-beer"));
		this.repo.save(new LineItem("Beer", "beer"));
	}
}
