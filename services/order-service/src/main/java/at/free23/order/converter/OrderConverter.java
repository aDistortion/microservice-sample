/**
 *
 */
package at.free23.order.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import at.free23.order.api.LineItemDto;
import at.free23.order.api.OrderDto;
import at.free23.order.model.Order;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class OrderConverter implements Converter<Order, OrderDto> {

	@Override
	public OrderDto convert(Order src) {
		final List<LineItemDto> items = src.getLineItems().stream()
				.map(i -> new LineItemDto(i.getUuid(), i.getQuantity())).collect(Collectors.toList());
		return new OrderDto(src.getOrderRef(), items);
	}

}
