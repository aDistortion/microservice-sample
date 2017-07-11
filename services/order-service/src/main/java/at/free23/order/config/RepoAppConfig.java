/**
 *
 */
package at.free23.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import at.free23.order.model.LineItem;
import at.free23.order.model.Order;
import at.free23.order.model.OrderLineItem;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class RepoAppConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Order.class, LineItem.class, OrderLineItem.class);
	}

	// @Override
	// public void configureConversionService(ConfigurableConversionService
	// conversionService) {
	// conversionService.addConverter(new OrderLineItemKeyConverter());
	// }
}
