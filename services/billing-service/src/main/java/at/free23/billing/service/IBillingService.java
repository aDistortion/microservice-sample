/**
 *
 */
package at.free23.billing.service;

import java.util.List;

import at.free23.billing.api.LineItemDto;
import at.free23.billing.model.Invoice;

/**
 * @author michael.vlasaty
 *
 */
public interface IBillingService {
	public Invoice createInvoice(String orderRef, List<LineItemDto> lineItems);

	public Invoice receivePayment(String orderRef);

	public void cancelInvoice(String orderRef);
}
