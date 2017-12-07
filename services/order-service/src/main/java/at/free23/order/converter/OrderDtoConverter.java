/**
 *
 */
package at.free23.order.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import at.free23.order.api.OrderDto;
import at.free23.order.model.LineItem;
import at.free23.order.model.Order;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderDtoConverter implements Converter<OrderDto, Order> {

	@Override
	public Order convert(OrderDto src) {
		final List<LineItem> orderItems = src.getLineItems().stream()
				.map(i -> new LineItem(i.getUuid(), i.getQuantity())).collect(Collectors.toList());
		return new Order(orderItems);
	}

}
