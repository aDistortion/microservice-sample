/**
 * 
 */
package at.free23.billing.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import at.free23.billing.api.Payment;

/**
 * @author michael.vlasaty
 *
 */
@Component
@RepositoryEventHandler(Payment.class)
public class PaymentRecievedHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaymentRecievedHandler.class);
	
	@Autowired
	private KafkaTemplate<String, ?> template;
	
	@HandleAfterSave
	public void onCreated(Payment savedPayment){
		if(savedPayment.getRecieved() != null){
			LOGGER.info("Sending payment");
			this.template.send(new GenericMessage<>(savedPayment));
		}
	}
}
