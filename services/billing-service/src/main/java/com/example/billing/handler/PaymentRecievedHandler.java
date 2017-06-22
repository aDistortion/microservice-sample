/**
 * 
 */
package com.example.billing.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.example.billing.api.Payment;

/**
 * @author michael.vlasaty
 *
 */
@Component
@RepositoryEventHandler(Payment.class)
public class PaymentRecievedHandler {

	@Autowired
	private KafkaTemplate<String, ?> template;
	
	@HandleAfterSave
	public void onCreated(Payment savedPayment){
		if(savedPayment.getRecieved() != null){
			this.template.send(new GenericMessage<>(savedPayment));
		}
	}
}
