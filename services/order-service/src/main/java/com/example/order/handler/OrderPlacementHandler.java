/**
 * 
 */
package com.example.order.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.example.order.api.Order;

/**
 * @author michael.vlasaty
 *
 */
@Component
@RepositoryEventHandler(Order.class)
public class OrderPlacementHandler {

	@Autowired
	private KafkaTemplate<String, ?> template;
	
	@HandleAfterCreate
	public void onCreated(Order newOrder){
		this.template.send(new GenericMessage<>(newOrder));
	}
}
