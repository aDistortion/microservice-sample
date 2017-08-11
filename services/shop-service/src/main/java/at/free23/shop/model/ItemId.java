/**
 *
 */
package at.free23.shop.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

/**
 * @author michael.vlasaty
 *
 */
@Embeddable
public class ItemId implements Serializable {
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;


	private Long cartId;
	private Long productId;

	public ItemId() {

	}

	public ItemId(String id) {
		final String ids[] = id.split("-");
		this.cartId = Long.valueOf(ids[0]);
		this.productId = Long.valueOf(ids[1]);
	}

	public ItemId(Long cartId, Long productId) {
		this.cartId = cartId;
		this.productId = productId;
	}

	public Long getCartId() {
		return this.cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getProductId() {
		return this.productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || this.getClass() != o.getClass()) {
			return false;
		}
		final ItemId that = (ItemId) o;
		return Objects.equals(this.getCartId(), that.getCartId()) && Objects.equals(this.getProductId(), that.getProductId());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.getCartId(), this.getProductId());
	}

	@Override
	public String toString() {
		return this.getCartId() + "-" + this.getProductId();
	}

}
