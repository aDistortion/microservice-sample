/**
 *
 */
package at.free23.stock.listener;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import at.free23.stock.api.OrderEvent;
import at.free23.stock.api.OrderPayload;
import at.free23.stock.api.ShippingEvent;
import at.free23.stock.api.ShippingPayload;
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
	private KafkaTemplate<String, ?> template;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void updateStock(OrderPayload payload) {
		switch (OrderEvent.valueOf(payload.getEvent())) {
		case ORDER_RCV:
			LOGGER.info("New order recieved, preparing items for shipping");
			final Double prepareTime = payload.getLineItems().stream()
					.map(i -> this.service.reserveItem(payload.getOrderRef(), i.getUuid(), i.getQuantity()))
					.max((d1, d2) -> Double.compare(d1, d2)).orElse(10D);

			try {
				Thread.sleep(200L);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			final ShippingPayload shippingReadyEv = new ShippingPayload(payload.getOrderRef(),
					ShippingEvent.SHIPPING_READY, prepareTime);
			final Map<String, Object> headers = Collections.singletonMap(KafkaHeaders.TOPIC, "shipping");
			this.template.send(new GenericMessage<>(shippingReadyEv, headers));
			break;
		case PAYMENT_RCV:
			LOGGER.info("Payment recieved, booking items for shipping");
			this.service.bookShipping(payload.getOrderRef());
			final OrderPayload shippingPayload = new OrderPayload(payload.getOrderRef(), ShippingEvent.SHIPPING_BOOKED);
			this.template.send(new GenericMessage<>(shippingPayload));
			break;
		case PAYMENT_OVERDUE:
			LOGGER.info("Cancelling reserved items due to payment overdue");
			this.service.cancelReservedItems(payload.getOrderRef());
			break;
		}
	}
}
