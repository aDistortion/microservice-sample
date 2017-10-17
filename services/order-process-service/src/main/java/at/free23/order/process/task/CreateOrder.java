/**
 *
 */
package at.free23.order.process.task;

import java.util.List;
import java.util.stream.Collectors;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.type.TypeReference;

import at.free23.order.process.api.ItemDto;
import at.free23.order.process.api.OrderDto;
import at.free23.order.process.api.OrderItem;
import at.free23.order.process.service.IOrderService;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class CreateOrder extends AbstractBaseTask {

	@Autowired
	private IOrderService service;

	@Override
	public void execute(DelegateExecution exec) throws Exception {
		final String tenantId = this.getVariable("tenantId", exec, String.class);
		final List<OrderItem> orderItems = this.getVariable("orderItems", exec, new TypeReference<List<OrderItem>>() {
		});

		final List<ItemDto> items = orderItems.stream().map(i -> new ItemDto(i)).collect(Collectors.toList());
		final OrderDto order = this.service.createOrder(tenantId, items);
		exec.setVariable("order", this.createVariable(order));
		exec.setVariable("orderRef", order.getOrderRef());
	}

}
