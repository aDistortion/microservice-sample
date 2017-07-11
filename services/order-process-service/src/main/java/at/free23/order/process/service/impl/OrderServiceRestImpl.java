/**
 *
 */
package at.free23.order.process.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import at.free23.order.process.api.LineItem;
import at.free23.order.process.api.Order;
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

	private static final String SERVICE_ID = "order-service";

	@Override
	public Order createOrder(Order newOrder) {
		final String uri = this.getInstance(SERVICE_ID);

		final ResponseEntity<Resource<Order>> response = this.restTemplate.exchange(uri + "/order", HttpMethod.POST,
				new HttpEntity<>(newOrder), new ParameterizedTypeReference<Resource<Order>>() {
		});

		final Order createdOrder = response.getBody().getContent();
		logger.info("Created order " + createdOrder.getOrderRef());

		// spring data rest forces a second call for many to many relations with
		// extra columns...
		this.addLineItem(createdOrder, newOrder.getLineItems());

		return createdOrder;
	}

	private void addLineItem(Order order, List<LineItem> items) {
		final String uri = this.getInstance(SERVICE_ID);

	}

	private String getInstance(String serviceId) {
		return this.discoveryClient.getInstances(SERVICE_ID).get(0).getUri().toString();
	}
}
