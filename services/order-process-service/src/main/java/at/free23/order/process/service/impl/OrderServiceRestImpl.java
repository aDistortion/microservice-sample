/**
 *
 */
package at.free23.order.process.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import at.free23.order.process.api.ItemDto;
import at.free23.order.process.api.OrderDto;
import at.free23.order.process.service.IOrderService;

/**
 * @author michael.vlasaty
 *
 */
@Service
public class OrderServiceRestImpl implements IOrderService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	protected DiscoveryClient discoveryClient;

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceRestImpl.class);

	@Value("${order.instance-id}")
	private String serviceId;

	@Value("${order.create.uri-prefix}")
	private String createUriPrefix;

	@Override
	public OrderDto createOrder(String tenantId, List<ItemDto> items) {
		final OrderDto newOrder = new OrderDto(tenantId, items);
		final String uri = this.getOrderInstance() + this.createUriPrefix;

		final ResponseEntity<OrderDto> response = this.restTemplate.exchange(uri, HttpMethod.POST,
				new HttpEntity<>(newOrder), new ParameterizedTypeReference<OrderDto>() {
		});

		final OrderDto createdOrder = response.getBody();
		logger.info("Created order " + createdOrder.getOrderRef());

		return createdOrder;
	}

	private String getOrderInstance() {
		return this.discoveryClient.getInstances(this.serviceId).get(0).getUri().toString();
	}

	/**
	 * @return the serviceId
	 */
	public String getServiceId() {
		return this.serviceId;
	}

	/**
	 * @param serviceId
	 *            the serviceId to set
	 */
	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	/**
	 * @return the createUriPrefix
	 */
	public String getCreateUriPrefix() {
		return this.createUriPrefix;
	}

	/**
	 * @param createUriPrefix
	 *            the createUriPrefix to set
	 */
	public void setCreateUriPrefix(String createUriPrefix) {
		this.createUriPrefix = createUriPrefix;
	}
}
