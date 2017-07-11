/**
 *
 */
package at.free23.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import at.free23.order.model.Order;
import at.free23.order.service.IOrderService;

/**
 * @author michael.vlasaty
 *
 */
@RestController
@RequestMapping("/")
public class OrderController {

	@Autowired
	private IOrderService service;

	// @Autowired
	// private OrderLineItemsRepository assocRepo;

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public @ResponseBody Order createOrder(@RequestBody Order newOrder) {
		return this.service.createOrder(newOrder);
	}
}
