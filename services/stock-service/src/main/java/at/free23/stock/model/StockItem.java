package at.free23.stock.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StockItem {

	@Id
	private Long id;

	private String uuid;

	private Long stored;

	private Double acquireTime;

	public StockItem() {
	}

	public StockItem(Long id, Long stored, Double acquireTime) {
		this.id = id;
		this.stored = stored;
		this.acquireTime = acquireTime;
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

	public Double getAcquireTime() {
		return this.acquireTime;
	}

	public void setAcquireTime(Double acquireTime) {
		this.acquireTime = acquireTime;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

}
