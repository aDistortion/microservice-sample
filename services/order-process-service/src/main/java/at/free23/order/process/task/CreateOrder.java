/**
 *
 */
package at.free23.order.process.task;

import java.util.List;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.Variables.SerializationDataFormats;
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

		final Order createdOrder = this.restTemplate.postForObject("http://localhost:8080/order", order, Order.class);
		this.logger.info("Created order " + createdOrder.getId());
		exec.setVariable("order",
				Variables.objectValue(order).serializationDataFormat(SerializationDataFormats.JSON).create());
		exec.setVariable("orderId", order.getId());
	}

}
