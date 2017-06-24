/**
 *
 */
package at.free23.order.process.config;

import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class ProcessEngineAppConfig {

	@ConditionalOnMissingBean(RestTemplate.class)
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public SpinProcessEnginePlugin spinProcessEnginePlugin() {
		return new SpinProcessEnginePlugin();
	}

	@Bean
	public DmnEngine dmnEngine() {
		return DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
	}
}
