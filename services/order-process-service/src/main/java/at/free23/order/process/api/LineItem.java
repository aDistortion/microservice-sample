package at.free23.order.process.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LineItem {

	private Long id;

	private Long quantity;

	public LineItem() {

	}

	public LineItem(Long id, Long quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
