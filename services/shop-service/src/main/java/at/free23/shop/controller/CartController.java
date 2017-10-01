/**
 *
 */
package at.free23.shop.controller;

import javax.servlet.http.HttpServletResponse;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.base.Strings;

import at.free23.shop.api.CartDto;
import at.free23.shop.api.ItemDto;
import at.free23.shop.model.Cart;
import at.free23.shop.service.CartService;

/**
 * @author michael.vlasaty
 *
 */
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	/**
	 * Interceptor um mandanten id konsistent bereit zu stellen.
	 *
	 * @param tenantId
	 * @return valid tenantId
	 */
	@ModelAttribute("tenantId")
	public String preprocessTenantId(@RequestHeader(value = "Authorization", required = false) String tenantId) {
		if (Strings.isNullOrEmpty(tenantId)) {
			tenantId = "anonymous" + LocalDateTime.now().getMillisOfDay();
		}
		return tenantId;
	}

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public @ResponseBody CartDto getCart(@ModelAttribute("tenantId") String tenantId, HttpServletResponse resp) {

		// TODO: abstract this call into some interceptor...
		resp.setHeader("Authorization", tenantId);

		final Cart cart = this.cartService.fetchCart(tenantId);
		return new CartDto(cart);
	}

	@RequestMapping(path = "/", method = RequestMethod.PUT)
	public @ResponseBody CartDto addItem(@ModelAttribute("tenantId") String tenantId, @RequestBody ItemDto item,
			HttpServletResponse resp) {

		resp.setHeader("Authorization", tenantId);
		final Cart cart = this.cartService.addItem(tenantId, item);
		return new CartDto(cart);
	}

	@RequestMapping(path = "/", method = RequestMethod.DELETE)
	public @ResponseBody CartDto removeItem(@ModelAttribute("tenantId") String tenantId, @RequestBody ItemDto item,
			HttpServletResponse resp) {
		resp.setHeader("Authorization", tenantId);
		final Cart cart = this.cartService.removeItem(tenantId, item);
		return new CartDto(cart);
	}

	// @RequestMapping(path = "/checkOut", method = RequestMethod.GET)
	// public ResponseEntity
}
