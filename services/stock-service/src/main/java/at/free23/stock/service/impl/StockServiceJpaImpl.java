/**
 *
 */
package at.free23.stock.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.stock.api.ReservedItem;
import at.free23.stock.api.StockItem;
import at.free23.stock.repository.ReservedItemRepository;
import at.free23.stock.repository.StockItemRepository;
import at.free23.stock.service.IStockService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class StockServiceJpaImpl implements IStockService {

	@Autowired
	private StockItemRepository stockRepo;

	@Autowired
	private ReservedItemRepository reservedRepo;

	@Override
	public void reserveItem(Long orderRef, Long itemId, Long quantity) {
		final StockItem onStock = this.stockRepo.findOne(itemId);
		if (onStock != null && onStock.getStored() >= quantity) {
			onStock.setStored(onStock.getStored() - quantity);
			this.stockRepo.save(onStock);
			this.reservedRepo.save(new ReservedItem(itemId, orderRef, quantity));
		} else {
			throw new IllegalStateException("Stock too low!");
		}
	}

	@Override
	public void bookShipping(Long orderRef) {
		final Iterable<ReservedItem> items = this.reservedRepo.findByIdOrderRef(orderRef);
		items.forEach(i -> this.reservedRepo.delete(i.getId()));
	}

}
