package at.free23.order.api;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name="orderEntity")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
    @SequenceGenerator(name = "idgen", sequenceName = "order_id_sequence", allocationSize = 1, initialValue = 1)
	private Long id;
	
	@OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
	private List<LineItem> lineItems;

	private boolean paymentRecieved = false;
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<LineItem> getLineItems() {
		return this.lineItems;
	}

	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public boolean isPaymentRecieved() {
		return this.paymentRecieved;
	}

	public void setPaymentRecieved(boolean paymentRecieved) {
		this.paymentRecieved = paymentRecieved;
	}
}
