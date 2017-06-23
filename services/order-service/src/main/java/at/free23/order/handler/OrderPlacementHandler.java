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
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import at.free23.order.api.Order;

/**
 * @author michael.vlasaty
 *
 */
@Component
@RepositoryEventHandler(Order.class)
public class OrderPlacementHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderPlacementHandler.class);
	
	@Autowired
	private KafkaTemplate<String, ?> template;
	
	@HandleAfterCreate
	public void onCreated(Order newOrder){
		this.template.send(new GenericMessage<>(newOrder));
		this.LOGGER.info("New order has been placed");
	}
}
