/**
 *
 */
package at.free23.stock.service.impl;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.stock.model.ReservedItem;
import at.free23.stock.model.StockItem;
import at.free23.stock.repository.ReservedItemRepository;
import at.free23.stock.repository.StockItemRepository;
import at.free23.stock.service.IStockService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class StockServiceJpaImpl implements IStockService {

	private static final Logger logger = LoggerFactory.getLogger(StockServiceJpaImpl.class);

	@Autowired
	private StockItemRepository stockRepo;

	@Autowired
	private ReservedItemRepository reservedRepo;

	@Override
	public Double reserveItem(String orderRef, String uuid, Integer quantity) {
		final StockItem onStock = this.stockRepo.findByUuid(uuid);
		if (onStock != null && onStock.getStored() >= quantity) {
			onStock.setStored(onStock.getStored() - quantity);
			this.stockRepo.save(onStock);
			this.reservedRepo.save(new ReservedItem(onStock.getId(), orderRef, quantity));
			logger.info(String.format("Reserved item %s - %s", onStock.getName(), quantity));
		} else {
			throw new IllegalStateException(String.format("Stock too low! [%s - %s] %s left", onStock.getUuid(),
					quantity, onStock.getStored()));
		}
		return onStock.getPreparationTime();
	}

	@Override
	public void bookShipping(String orderRef) {
		final Iterable<ReservedItem> items = this.reservedRepo.findByIdOrderRef(orderRef);
		final Iterator<ReservedItem> it = items.iterator();
		while (it.hasNext()) {
			final ReservedItem item = it.next();
			item.setShippingBooked(true);
			this.reservedRepo.save(item);
			logger.info("Booked shipping for reserved item " + item.getId());
		}
	}

	@Override
	public void cancelReservedItems(String orderRef) {
		final Iterable<ReservedItem> items = this.reservedRepo.findByIdOrderRef(orderRef);
		final Iterator<ReservedItem> it = items.iterator();
		while (it.hasNext()) {
			final ReservedItem item = it.next();
			final StockItem stockItem = this.stockRepo.findOne(item.getId().getItemId());
			stockItem.setStored(stockItem.getStored() + item.getAmount());
			this.reservedRepo.delete(item.getId());
			this.stockRepo.save(stockItem);
			logger.info("Canceled reserved item " + item.getId());
		}
	}

}
