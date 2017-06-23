/**
 *
 */
package at.free23.order.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import at.free23.order.api.Order;
import at.free23.order.api.OrderEvent;
import at.free23.order.api.OrderPayload;
import at.free23.order.api.TransactionPayload;

/**
 * @author michael.vlasaty
 *
 */
@Component
@RepositoryEventHandler(Order.class)
public class OrderPlacementHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderPlacementHandler.class);

	@Autowired
	private KafkaTemplate<String, TransactionPayload> template;

	@HandleAfterCreate
	public void onCreated(Order newOrder){
		final OrderPayload payload = new OrderPayload(newOrder.getId(), OrderEvent.ORDER_RCV,
				newOrder.getLineItems());
		this.template.send("order",payload);
		LOGGER.info("New order has been placed");
	}
}
