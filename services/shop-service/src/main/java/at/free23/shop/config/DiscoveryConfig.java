/**
 *
 */
package at.free23.shop.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
@EnableDiscoveryClient
public class DiscoveryConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
