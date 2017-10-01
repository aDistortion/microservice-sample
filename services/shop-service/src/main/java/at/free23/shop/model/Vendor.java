/**
 *
 */
package at.free23.shop.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 * @author michael.vlasaty
 *
 */
@Entity
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")
	@SequenceGenerator(name = "idgen", sequenceName = "vendor_id_sequence", allocationSize = 1, initialValue = 1)
	private Long id;

	private String name;
	private String country;

	@OneToMany(mappedBy = "vendor")
	private List<Product> products;

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return this.country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the products
	 */
	public List<Product> getProducts() {
		return this.products;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
