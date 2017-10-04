/**
 *
 */
package at.free23.stock.initializer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.free23.stock.model.ReservedItem;
import at.free23.stock.repository.ReservedItemRepository;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class ReservedItemInitializer {

	@Autowired
	private ReservedItemRepository itemRepo;

	@PostConstruct
	public void init() {
		this.itemRepo.save(new ReservedItem(1L, "123", 2));
		this.itemRepo.save(new ReservedItem(2L, "123", 4));
		this.itemRepo.save(new ReservedItem(3L, "123", 1));
		this.itemRepo.save(new ReservedItem(1L, "123", 2));
		this.itemRepo.save(new ReservedItem(3L, "123", 1));
	}
}
