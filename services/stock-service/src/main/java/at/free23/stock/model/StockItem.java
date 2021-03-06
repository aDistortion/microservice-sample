package at.free23.stock.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StockItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String uuid;
	private String name;

	private Integer stored;

	private String locationId;

	private Double preparationTime;
	private Double acquireTime;

	public StockItem() {
	}

	public StockItem(String uuid, String name, Integer stored, String locationId, Double acquireTime,
			Double preparationTime) {
		this.uuid = uuid;
		this.name = name;
		this.stored = stored;
		this.acquireTime = acquireTime;
		this.preparationTime = preparationTime;
		this.locationId = locationId;
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getStored() {
		return this.stored;
	}

	public void setStored(Integer stored) {
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

	public Double getPreparationTime() {
		return this.preparationTime;
	}

	public void setPreparationTime(Double preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the locationId
	 */
	public String getLocationId() {
		return this.locationId;
	}

	/**
	 * @param locationId
	 *            the locationId to set
	 */
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

}
