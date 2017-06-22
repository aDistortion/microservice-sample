/**
 * 
 */
package com.example.billing.api;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pidgen")
    @SequenceGenerator(name = "pidgen", sequenceName = "payment_id_sequence", allocationSize = 1, initialValue = 1)
	private Long id;
	
	private Long orderId;
	
	private LocalDateTime recieved;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getRecieved() {
		return recieved;
	}

	public void setRecieved(LocalDateTime recieved) {
		this.recieved = recieved;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

}
