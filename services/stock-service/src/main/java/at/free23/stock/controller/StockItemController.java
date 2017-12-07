/**
 *
 */
package at.free23.stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import at.free23.stock.api.StockItemDto;
import at.free23.stock.model.StockItem;
import at.free23.stock.repository.StockItemRepository;

/**
 * @author michael.vlasaty
 *
 */
@RestController
@RequestMapping("/stockItem")
public class StockItemController {

	@Autowired
	private StockItemRepository stockRepo;

	@RequestMapping(value = "/{uuid}", method = RequestMethod.GET)
	public StockItemDto getStockItem(@PathVariable("uuid") String uuid) {
		final StockItem item = this.stockRepo.findByUuid(uuid);
		return new StockItemDto(item);
	}
}
