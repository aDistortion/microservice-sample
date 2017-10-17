/**
 *
 */
package at.free23.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import at.free23.shop.api.client.ItemDto;
import at.free23.shop.service.IStockService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class StockService implements IStockService {

	@Autowired
	private DiscoveryClient discoveryClient;

	@Autowired
	private RestTemplate template;

	@Value("${stock.instance-id}")
	private String stockInstanceId;

	@Value("${stock.item.uri-prefix}")
	private String stockItemUriPrefix;

	/* (non-Javadoc)
	 * @see at.free23.shop.service.IStockService#fetchStockItem(java.lang.String)
	 */
	@Override
	public ItemDto fetchStockItem(String uuid) {
		final String uri = this.getStockServiceUri() + this.stockItemUriPrefix + uuid;
		return this.template.getForObject(uri, ItemDto.class);
	}

	private String getStockServiceUri() {
		return this.discoveryClient.getInstances(this.stockInstanceId).get(0).getUri().toString();
	}

	/**
	 * @return the stockInstanceId
	 */
	public String getStockInstanceId() {
		return this.stockInstanceId;
	}

	/**
	 * @param stockInstanceId
	 *            the stockInstanceId to set
	 */
	public void setStockInstanceId(String stockInstanceId) {
		this.stockInstanceId = stockInstanceId;
	}

	/**
	 * @return the stockItemUriPrefix
	 */
	public String getStockItemUriPrefix() {
		return this.stockItemUriPrefix;
	}

	/**
	 * @param stockItemUriPrefix
	 *            the stockItemUriPrefix to set
	 */
	public void setStockItemUriPrefix(String stockItemUriPrefix) {
		this.stockItemUriPrefix = stockItemUriPrefix;
	}

}
