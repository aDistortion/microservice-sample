/**
 *
 */
package at.free23.billing.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import at.free23.billing.api.OrderEvent;
import at.free23.billing.api.OrderPayload;
import at.free23.billing.api.Payment;
import at.free23.billing.repository.PaymentRepository;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

	@Autowired
	private PaymentRepository repo;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void order(OrderPayload payload){
		final OrderEvent event = OrderEvent.valueOf(payload.getEvent());
		switch (event) {
		case ORDER_RCV:
			this.orderRecieved(payload);
			break;
		case ITEM_WONT_SHIP:
			break;
		case PAYMENT_OVERDUE:
			break;
		case PAYMENT_RCV:
			break;
		case SHIPPING_BOOKED:
			break;
		case SHIPPING_DELAYED:
			break;
		default:
			break;
		}
	}

	private void orderRecieved(OrderPayload payload) {
		LOGGER.info("New order recieved preparing payment...");
		final Payment payment = new Payment();
		payment.setOrderId(payload.getOrderRef());
		payment.setLineItems(payload.getLineItems());
		LOGGER.info(payment.toString());
		this.repo.save(payment);
	}
}
