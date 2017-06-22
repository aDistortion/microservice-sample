/**
 * 
 */
package com.example.billing.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import com.example.billing.api.Order;
import com.example.billing.api.Payment;
import com.example.billing.repository.PaymentRepository;

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
