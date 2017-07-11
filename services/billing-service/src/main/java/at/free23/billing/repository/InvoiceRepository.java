/**
 * 
 */
package at.free23.billing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.billing.model.Invoice;

/**
 * @author michael.vlasaty
 *
 */
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long>{

}
