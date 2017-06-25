/**
 *
 */
package at.free23.order.handler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

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

	@HandleBeforeCreate
	public void beforeCreate(Order transientOrder) {
		final LocalDateTime now = LocalDateTime.now();
		final StringBuilder builder = new StringBuilder();
		builder.append(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		builder.append(now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		transientOrder.setOrderRef(builder.toString());
	}

	@HandleAfterCreate
	public void onCreated(Order newOrder){
		final OrderPayload payload = new OrderPayload(newOrder.getOrderRef(), OrderEvent.ORDER_RCV,
				newOrder.getLineItems());
		final ListenableFuture<SendResult<String, TransactionPayload>> future = this.template.send("order", payload);
		LOGGER.info("New order has been placed");
	}
}
