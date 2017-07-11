/**
 *
 */
package at.free23.order.process.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import at.free23.order.process.api.Order;
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
		final Order order = this.getVariable("order", exec, Order.class);
		order.setPaymentRecieved(false);


		final Order createdOrder = this.service.createOrder(order);
		exec.setVariable("order", this.createVariable(createdOrder));
		exec.setVariable("orderRef", createdOrder.getOrderRef());
	}

}
