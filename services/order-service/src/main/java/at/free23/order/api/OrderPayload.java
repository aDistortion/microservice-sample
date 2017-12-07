/**
 *
 */
package at.free23.order.api;

import java.util.List;

import com.google.common.collect.Lists;

import at.free23.order.model.LineItem;

/**
 * @author michael.vlasaty
 *
 */
public class OrderPayload extends TransactionPayload {

	private List<LineItemDto> lineItems;

	public OrderPayload(String orderRef, OrderEvent event, List<LineItem> items) {
		this.orderRef = orderRef;
		this.event = event.toString();
		this.lineItems = Lists.newArrayList();
		items.stream().forEach(i -> this.lineItems
				.add(new LineItemDto(i.getUuid(), i.getQuantity())));
	}

	public List<LineItemDto> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItemDto> lineItems) {
		this.lineItems = lineItems;
	}
}
