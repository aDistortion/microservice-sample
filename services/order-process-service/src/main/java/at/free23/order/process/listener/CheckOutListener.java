/**
 *
 */
package at.free23.order.process.listener;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import at.free23.order.process.api.CartAction;
import at.free23.order.process.api.CartActionType;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class CheckOutListener {

	@Autowired
	private RuntimeService runtimeService;

	@KafkaListener(topics = "shop", containerFactory = "jsonKafkaListenerContainerFactory")
	public void checkOut(CartAction action) {
		switch (CartActionType.valueOf(action.getType().toString())) {
		case CHECK_OUT:
			final Map<String, Object> variables = new HashMap<>();
			variables.put("orderItems", action.getOrderItems());
			variables.put("tenantId", action.getTenantId());
			variables.put("checkOutId", action.getCheckOutId());
			this.runtimeService.startProcessInstanceByMessage(CartActionType.CHECK_OUT.toString(), variables);
			break;
		default:
			break;
		}
	}
}
