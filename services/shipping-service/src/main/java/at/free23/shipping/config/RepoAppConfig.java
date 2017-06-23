/**
 *
 */
package at.free23.shipping.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class RepoAppConfig extends RepositoryRestConfigurerAdapter {
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		// config.exposeIdsFor(StockItem.class, ReservedItem.class);
	}
}
