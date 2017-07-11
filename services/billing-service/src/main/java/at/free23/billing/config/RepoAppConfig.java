/**
 *
 */
package at.free23.billing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import at.free23.billing.model.LineItem;
import at.free23.billing.repository.PositionIdConverter;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class RepoAppConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(LineItem.class);
	}

	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
		conversionService.addConverter(new PositionIdConverter());
	}
}
