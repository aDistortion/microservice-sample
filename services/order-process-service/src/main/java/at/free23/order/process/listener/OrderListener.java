/**
 *
 */
package at.free23.order.process.listener;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import at.free23.order.process.api.OrderEvent;
import at.free23.order.process.api.OrderPayload;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderListener {

	@Autowired
	private RuntimeService runtimeService;

	@KafkaListener(topics = "order", containerFactory = "jsonKafkaListenerContainerFactory")
	public void order(OrderPayload payload) {
		switch (OrderEvent.valueOf(payload.getEvent())) {
		case ITEM_WONT_SHIP:
			break;
		case PAYMENT_OVERDUE:
			break;
		case PAYMENT_RCV:
			this.runtimeService.createMessageCorrelation(OrderEvent.PAYMENT_RCV.toString())
			.processDefinitionId("orderProcess").processInstanceVariableEquals("orderId", payload.getOrderRef())
			.setVariable("paymentRecieved", true).correlateExclusively();
			break;
		case SHIPPING_BOOKED:
			this.runtimeService.createMessageCorrelation(OrderEvent.SHIPPING_BOOKED.toString())
			.processDefinitionId("orderProcess").processInstanceVariableEquals("orderId", payload.getOrderRef())
			.setVariable("shippingBooked", true).correlateExclusively();
			break;
		case SHIPPING_DELAYED:
			break;
		default:
			break;

		}
	}
}
