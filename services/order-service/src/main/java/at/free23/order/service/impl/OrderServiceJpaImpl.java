/**
 *
 */
package at.free23.order.service.impl;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.free23.order.model.LineItem;
import at.free23.order.model.Order;
import at.free23.order.repository.LineItemRepository;
import at.free23.order.repository.OrderRepository;
import at.free23.order.service.IOrderService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class OrderServiceJpaImpl implements IOrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceJpaImpl.class);

	@Autowired
	private OrderRepository repo;

	@Autowired
	private LineItemRepository itemRepo;

	@Override
	public Order createOrder(Order newOrder) {
		logger.info("Creating " + newOrder);
		final List<LineItem> orderLineItems = newOrder.getLineItems();
		newOrder.setLineItems(null);

		final Order order = this.repo.save(newOrder);

		/*
		 * final List<OrderLineItem> savedItems = Lists.newArrayList(); final
		 * Iterator<LineItem> it = orderLineItems.iterator(); while
		 * (it.hasNext()) { final LineItem item = it.next(); final LineItem
		 * lineItem = this.itemRepo.findByUuid(item.getUuid()); final
		 * OrderLineItemId newId = new OrderLineItemId(order.getId(),
		 * lineItem.getId());
		 * 
		 * item.setId(newId); item.setOrder(order); item.setLineItem(lineItem);
		 * 
		 * final OrderLineItem assoc = this.assocRepo.save(item);
		 * savedItems.add(assoc); } order.setOrderLineItems(savedItems);
		 */
		return order;
	}

	@Override
	public Order addItem(Long orderId, Long lineItemId) {
		throw new NotImplementedException("Nice try!");
	}

	@Override
	public void removeItem(Long orderId, Long lineItemId) {
		throw new NotImplementedException("Nice try!");
	}

}
