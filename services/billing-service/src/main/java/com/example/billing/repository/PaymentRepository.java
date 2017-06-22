/**
 * 
 */
package com.example.billing.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.billing.api.Payment;

/**
 * @author michael.vlasaty
 *
 */
public interface PaymentRepository extends PagingAndSortingRepository<Payment, Long>{

}
