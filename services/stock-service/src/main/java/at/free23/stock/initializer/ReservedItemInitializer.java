/**
 *
 */
package at.free23.stock.initializer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.free23.stock.api.ReservedItem;
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
		this.itemRepo.save(new ReservedItem(1L, 1L, 2L));
		this.itemRepo.save(new ReservedItem(2L, 1L, 4L));
		this.itemRepo.save(new ReservedItem(3L, 1L, 1L));
		this.itemRepo.save(new ReservedItem(1L, 2L, 2L));
		this.itemRepo.save(new ReservedItem(3L, 2L, 1L));
	}
}
