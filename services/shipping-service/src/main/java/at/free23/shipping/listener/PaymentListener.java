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
import at.free23.shipping.api.ShippingNote;
import at.free23.shipping.repository.ShippingNoteRepository;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class PaymentListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentListener.class);

	@Autowired
	private ShippingNoteRepository repo;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void payment(OrderPayload payload) {
		switch (OrderEvent.valueOf(payload.getEvent())) {
		case ITEM_WONT_SHIP:
			break;
		case PAYMENT_RCV:
			LOGGER.info("Preparing shipping note...");
			this.repo.save(new ShippingNote(payload.getOrderRef()));
		case SHIPPING_BOOKED:
			LOGGER.info("Sending shipping note...");
			final ShippingNote ready = this.repo.findByOrderRef(payload.getOrderRef());
			ready.setShipped(true);
			this.repo.save(ready);
			break;
		}
	}
}
