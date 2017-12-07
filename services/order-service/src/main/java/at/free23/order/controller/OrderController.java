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

import at.free23.order.api.OrderDto;
import at.free23.order.converter.OrderConverter;
import at.free23.order.converter.OrderDtoConverter;
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

	@Autowired
	private OrderDtoConverter dtoConverter;

	@Autowired
	private OrderConverter orderConverter;

	@RequestMapping(value = "/createOrder", method = RequestMethod.POST)
	public @ResponseBody OrderDto createOrder(@RequestBody OrderDto newOrder) {
		return this.orderConverter.convert(this.service.createOrder(this.dtoConverter.convert(newOrder)));
	}
}
