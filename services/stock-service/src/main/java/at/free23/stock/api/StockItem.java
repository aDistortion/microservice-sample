package at.free23.stock.api;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockItem {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long stored;

	public StockItem() {
	}

	public StockItem(Long id, Long stored) {
		this.id = id;
		this.stored = stored;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStored() {
		return this.stored;
	}

	public void setStored(Long stored) {
		this.stored = stored;
	}
}
