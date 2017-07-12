/**
 *
 */
package at.free23.shipping.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import at.free23.shipping.api.OrderEvent;
import at.free23.shipping.api.OrderPayload;
import at.free23.shipping.model.ShippingNote;
import at.free23.shipping.service.IShippingService;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

	@Autowired
	private IShippingService service;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void payment(OrderPayload payload) {
		switch (OrderEvent.valueOf(payload.getEvent())) {
		case ORDER_RCV:
			LOGGER.info("Preparing shipping note...");
			final ShippingNote note = this.service.createShippingNote(payload.getOrderRef(), payload.getLineItems());
			break;
		case SHIPPING_BOOKED:
			LOGGER.info("Sending shipping note...");
			// final ShippingNote ready =
			// this.repo.findByOrderRef(payload.getOrderRef());
			// ready.setShipped(true);
			// this.repo.save(ready);
			break;
		}
	}

}
