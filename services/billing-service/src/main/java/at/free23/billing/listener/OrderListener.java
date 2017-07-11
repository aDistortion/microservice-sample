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
import at.free23.billing.model.Invoice;
import at.free23.billing.service.IBillingService;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderListener {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderListener.class);

	@Autowired
	private IBillingService service;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void order(OrderPayload payload){
		final OrderEvent event = OrderEvent.valueOf(payload.getEvent());
		switch (event) {
		case ORDER_RCV:
			final Invoice invoice = this.service.createInvoice(payload.getOrderRef(), payload.getLineItems());
			LOGGER.info(String.format("New invoice created [%s - %s]", invoice.getId(), invoice.getOrderRef()));
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
}
