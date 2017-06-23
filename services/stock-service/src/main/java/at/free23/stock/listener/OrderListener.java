/**
 *
 */
package at.free23.stock.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import at.free23.stock.api.OrderEvent;
import at.free23.stock.api.OrderPayload;
import at.free23.stock.service.IStockService;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

	@Autowired
	private IStockService service;

	@Autowired
	private KafkaTemplate<String, ?> temlpate;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void updateStock(OrderPayload payload) {
		LOGGER.info("Recieved orderPayload!");
		switch (OrderEvent.valueOf(payload.getEvent())) {
		case ORDER_RCV:
			payload.getLineItems().stream()
			.forEach(i -> this.service.reserveItem(payload.getOrderRef(), i.getId(), i.getQuantity()));
			break;
		case PAYMENT_RCV:
			this.service.bookShipping(payload.getOrderRef());
			final OrderPayload shippingPayload = new OrderPayload(payload.getOrderRef(), OrderEvent.SHIPPING_BOOKED);
			this.temlpate
					.send(new GenericMessage<>(shippingPayload));
			break;
		case PAYMENT_OVERDUE:
			break;
		}
	}
}
