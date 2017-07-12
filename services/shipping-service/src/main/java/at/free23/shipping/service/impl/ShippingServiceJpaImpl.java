/**
 *
 */
package at.free23.shipping.service.impl;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import at.free23.shipping.api.LineItemDto;
import at.free23.shipping.model.ShippingDetail;
import at.free23.shipping.model.ShippingDetailId;
import at.free23.shipping.model.ShippingNote;
import at.free23.shipping.model.StockItem;
import at.free23.shipping.repository.ShippingDetailRepository;
import at.free23.shipping.repository.ShippingNoteRepository;
import at.free23.shipping.repository.StockItemRepository;
import at.free23.shipping.service.IShippingService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class ShippingServiceJpaImpl implements IShippingService {

	@Autowired
	private ShippingNoteRepository noteRepo;

	@Autowired
	private StockItemRepository itemRepo;

	@Autowired
	private ShippingDetailRepository detailRepo;

	/* (non-Javadoc)
	 * @see at.free23.shipping.service.IShippingService#createShippingNote(java.lang.String)
	 */
	@Override
	public ShippingNote createShippingNote(String orderRef, List<LineItemDto> items) {
		ShippingNote note = new ShippingNote(orderRef);
		note = this.noteRepo.save(note);

		final List<ShippingDetail> details = Lists.newArrayList();
		final Iterator<LineItemDto> it = items.iterator();
		while (it.hasNext()) {
			final LineItemDto itemDto = it.next();
			final StockItem item = this.itemRepo.findByUuid(itemDto.getUuid());
			final ShippingDetail detail = new ShippingDetail();
			detail.setItem(item);
			detail.setNote(note);
			detail.setQuantity(itemDto.getQuantity());
			detail.setId(new ShippingDetailId(note.getId(), item.getId()));
			this.detailRepo.save(detail);
			details.add(detail);
		}
		note.setDetails(details);

		return this.noteRepo.save(note);
	}

	/* (non-Javadoc)
	 * @see at.free23.shipping.service.IShippingService#updateDeliveryDate(java.lang.String, java.time.LocalDate)
	 */
	@Override
	public ShippingNote updateDeliveryDate(String orderRef, LocalDate newArrival) {
		final ShippingNote note = this.noteRepo.findByOrderRef(orderRef);
		note.setExpectedArrival(newArrival);
		return this.noteRepo.save(note);
	}

	/* (non-Javadoc)
	 * @see at.free23.shipping.service.IShippingService#cancelShipping(java.lang.String)
	 */
	@Override
	public void cancelShipping(String orderRef) {
		throw new NotImplementedException("Nice try!");
	}

}
