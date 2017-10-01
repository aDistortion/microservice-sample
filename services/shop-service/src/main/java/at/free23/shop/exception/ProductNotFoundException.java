/**
 *
 */
package at.free23.shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author michael.vlasaty
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	private String uuid;

	public ProductNotFoundException() {
		super();
	}

	public ProductNotFoundException(String uuid) {
		super();
		this.setUuid(uuid);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
