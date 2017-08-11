/**
 *
 */
package at.free23.shop.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class Item implements Serializable {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ItemId id;

	@JsonIgnore
	@ManyToOne
	@MapsId("cartId")
	private Cart cart;

	@JsonIgnore
	@ManyToOne
	@MapsId("productId")
	private Product product;

	private Integer amount;

	public Item() {
	}

	public Item(ItemId id) {
		this.id = id;
	}

	public Item(Cart cart, Product product) {
		this.cart = cart;
		this.product = product;
		this.id = new ItemId(cart.getId(), product.getId());
		this.amount = 0;
	}

	public ItemId getId() {
		return this.id;
	}

	public void setId(ItemId id) {
		this.id = id;
	}

	public Cart getCart() {
		return this.cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getAmount() {
		return this.amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final Item that = (Item) o;
		return Objects.equals(this.getCart(), that.getCart()) && Objects.equals(this.getProduct(), that.getProduct());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getCart(), this.getProduct());
	}

	@Override
	public String toString() {
		return ReflectionToStringBuilder.toString(this);
	}
}
