package at.free23.order.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
// @JsonTypeName(value="lineItem")
public class LineItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long lineItemId;

	private String name;
	private String uuid;

	@OneToMany(mappedBy = "lineItem", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<OrderLineItem> orderLineItems;

	public LineItem() {

	}

	public LineItem(String name, String uuid) {
		this.name = name;
		this.uuid = uuid;
	}

	public Long getLineItemId() {
		return this.lineItemId;
	}

	public void setLineItemId(Long lineItemId) {
		this.lineItemId = lineItemId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OrderLineItem> getOrderLineItems() {
		return this.orderLineItems;
	}

	public void setOrderLineItems(List<OrderLineItem> orderLineItems) {
		this.orderLineItems = orderLineItems;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
