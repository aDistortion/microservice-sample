package at.free23.shipping.api;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LineItem {

	@Id
	private Long id;

	private Long quantity;

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
