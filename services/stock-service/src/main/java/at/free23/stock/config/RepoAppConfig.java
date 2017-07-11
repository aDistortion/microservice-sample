/**
 *
 */
package at.free23.stock.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.ConfigurableConversionService;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import at.free23.stock.model.ReservedItem;
import at.free23.stock.model.StockItem;
import at.free23.stock.repository.ReservedIdConverter;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class RepoAppConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(StockItem.class, ReservedItem.class);
	}

	@Override
	public void configureConversionService(ConfigurableConversionService conversionService) {
		conversionService.addConverter(new ReservedIdConverter());
	}
}
