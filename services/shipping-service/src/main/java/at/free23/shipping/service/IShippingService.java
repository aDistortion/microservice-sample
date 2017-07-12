/**
 *
 */
package at.free23.shipping.service;

import java.time.LocalDate;
import java.util.List;

import at.free23.shipping.api.LineItemDto;
import at.free23.shipping.model.ShippingNote;

/**
 * @author michael.vlasaty
 *
 */
public interface IShippingService {

	public ShippingNote createShippingNote(String orderRef, List<LineItemDto> items);

	public ShippingNote updateDeliveryDate(String orderRef, LocalDate newArrival);

	public void cancelShipping(String orderRef);
}
