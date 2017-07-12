/**
 *
 */
package at.free23.billing.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;

import at.free23.billing.api.LineItemDto;
import at.free23.billing.model.Invoice;
import at.free23.billing.model.LineItem;
import at.free23.billing.model.Position;
import at.free23.billing.model.PositionId;
import at.free23.billing.repository.InvoiceRepository;
import at.free23.billing.repository.LineItemRepository;
import at.free23.billing.repository.PositionRepository;
import at.free23.billing.service.IBillingService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class BillingServiceJpaImpl implements IBillingService {

	@Autowired
	private InvoiceRepository invoiceRepo;

	@Autowired
	private LineItemRepository lineItemRepo;

	@Autowired
	private PositionRepository positionRepo;

	/* (non-Javadoc)
	 * @see at.free23.billing.service.IBillingService#createPayment(java.lang.Long, java.util.List)
	 */
	@Override
	public Invoice createInvoice(String orderRef, List<LineItemDto> lineItems) {
		Invoice invoice = this.invoiceRepo.save(new Invoice(orderRef));
		final List<Position> positions = lineItems.stream().map(this::readDto).collect(Collectors.toList());

		final List<Position> savedPos = Lists.newArrayList();
		final Iterator<Position> it = positions.iterator();
		while (it.hasNext()) {
			final Position position = it.next();
			this.fetchLineItem(position);

			position.setInvoice(invoice);
			position.setId(new PositionId(invoice.getId(), position.getLineItem().getId()));
			savedPos.add(this.positionRepo.save(position));

			invoice.setGrossTotal(invoice.getGrossTotal() + position.getTotal());
		}
		invoice.setCurrency("EUR");
		invoice.setPositions(savedPos);
		invoice = this.invoiceRepo.save(invoice);
		return invoice;
	}

	private Position readDto(LineItemDto itemDto) {
		return new Position(new LineItem(itemDto.getUuid()), itemDto.getQuantity());
	}

	private void fetchLineItem(Position position) {
		final LineItem item = this.lineItemRepo.findByUuid(position.getLineItem().getUuid());
		position.setTotal(item.getPrice() * position.getQuantity());
		position.setLineItem(item);
	}

	/* (non-Javadoc)
	 * @see at.free23.billing.service.IBillingService#receivePayment(java.lang.Long)
	 */
	@Override
	public Invoice receivePayment(String orderRef) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see at.free23.billing.service.IBillingService#cancelPayme(java.lang.Long)
	 */
	@Override
	public void cancelInvoice(String orderRef) {
		// TODO Auto-generated method stub

	}

}
