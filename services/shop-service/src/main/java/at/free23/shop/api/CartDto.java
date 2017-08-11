/**
 *
 */
package at.free23.shop.api;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

import at.free23.shop.model.Cart;

/**
 * @author michael.vlasaty
 *
 */
public class CartDto {

	private List<ItemDto> items;

	public CartDto() {

	}

	public CartDto(Cart cart) {
		if (cart.getItems() != null && cart.getItems().isEmpty() == false) {
			this.items = cart.getItems().stream().map(i -> new ItemDto(i)).collect(Collectors.toList());
		} else {
			this.items = Lists.newArrayList();
		}
	}

	public List<ItemDto> getItems() {
		return this.items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}
}
