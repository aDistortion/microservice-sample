package at.free23.order.api;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName(value="lineItem")
public class LineItem {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long quantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
}
