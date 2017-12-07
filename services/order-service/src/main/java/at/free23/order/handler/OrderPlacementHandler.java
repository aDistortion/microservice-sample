/**
 *
 */
package at.free23.order.handler;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import at.free23.order.api.TransactionPayload;
import at.free23.order.model.Order;

/**
 * @author michael.vlasaty
 *
 */
@Aspect
@Component
public class OrderPlacementHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderPlacementHandler.class);

	@Autowired
	private KafkaTemplate<String, TransactionPayload> template;

	@Before("execution(* at.free23.order.service.IOrderService.createOrder(..)) && args(transientOrder)")
	public void beforeCreate(Order transientOrder) {
		final LocalDateTime now = LocalDateTime.now();
		final StringBuilder builder = new StringBuilder();
		builder.append(now.format(DateTimeFormatter.ofPattern("yyyyMMdd")));
		builder.append(now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
		transientOrder.setOrderRef(builder.toString());
	}

	@AfterReturning(pointcut = "execution(* at.free23.order.service.IOrderService.createOrder(..))", returning = "newOrder")
	public void onCreated(Order newOrder){
		// final OrderPayload payload = new OrderPayload(newOrder.getOrderRef(),
		// OrderEvent.ORDER_RCV,
		// newOrder.getLineItems());
		// this.template.send("order", payload);
		LOGGER.info("New order has been placed");
	}

}
