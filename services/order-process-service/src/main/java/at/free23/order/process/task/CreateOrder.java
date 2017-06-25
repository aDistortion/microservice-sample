/**
 *
 */
package at.free23.order.process.task;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import at.free23.order.process.api.LineItem;
import at.free23.order.process.api.Order;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class CreateOrder extends AbstractBaseTask {

	@Override
	public void execute(DelegateExecution exec) throws Exception {
		final Order order = new Order();
		order.setPaymentRecieved(false);
		final List<LineItem> lineItems = Lists.newArrayList();
		for (int i = 0; i < 4; i++) {
			lineItems.add(new LineItem(Integer.toUnsignedLong(i), 5L));
		}
		order.setLineItems(lineItems);

		final HttpEntity<Order> request = new HttpEntity<>(order);
		final ResponseEntity<Resource<Order>> response = this.restTemplate.exchange("http://localhost:8080/order",
				HttpMethod.POST,
				request,
				new ParameterizedTypeReference<Resource<Order>>() {
		});
		final Resource<Order> orderResource = response.getBody();
		final Order createdOrder = orderResource.getContent();

		// TODO: id null?
		this.logger.info("Created order " + createdOrder.getOrderRef());
		exec.setVariable("order",
				Variables.objectValue(createdOrder).serializationDataFormat(SerializationDataFormats.JSON)
				.create());
		exec.setVariable("orderRef", createdOrder.getOrderRef());
	}

}
