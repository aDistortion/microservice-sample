/**
 * 
 */
package at.free23.billing.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import at.free23.billing.api.Order;
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
	public void order(Order order){
		LOGGER.info("New order recieved preparing payment...");
		Payment payment = new Payment();
		payment.setOrderId(order.getId());
		this.repo.save(payment);
	}
}
