/**
 *
 */
package at.free23.order.repository;

import org.springframework.core.convert.converter.Converter;

import at.free23.order.model.OrderLineItemId;

/**
 * @author michael.vlasaty
 *
 */
public class OrderLineItemKeyConverter implements Converter<String, OrderLineItemId> {

	@Override
	public OrderLineItemId convert(String source) {
		// final String[] ids = source.split("-");
		return new OrderLineItemId(Long.valueOf(source));
	}

}
