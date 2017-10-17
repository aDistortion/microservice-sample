/**
 *
 */
package at.free23.order.process.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author michael.vlasaty
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class CartDto {

	private List<ItemDto> items;

	public CartDto() {

	}

	public List<ItemDto> getItems() {
		return this.items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

}
