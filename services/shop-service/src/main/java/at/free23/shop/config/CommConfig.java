/**
 *
 */
package at.free23.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class CommConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
