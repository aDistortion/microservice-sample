/**
 *
 */
package at.free23.billing.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import at.free23.billing.api.LineItem;

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
}
