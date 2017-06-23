/**
 * 
 */
package at.free23.billing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import at.free23.billing.api.Payment;

/**
 * @author michael.vlasaty
 *
 */
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>{

}
