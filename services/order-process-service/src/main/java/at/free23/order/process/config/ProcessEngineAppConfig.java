/**
 *
 */
package at.free23.order.process.config;

import org.camunda.bpm.dmn.engine.DmnEngine;
import org.camunda.bpm.dmn.engine.DmnEngineConfiguration;
import org.camunda.spin.plugin.impl.SpinProcessEnginePlugin;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class ProcessEngineAppConfig {

	@Bean
	public SpinProcessEnginePlugin spinProcessEnginePlugin() {
		return new SpinProcessEnginePlugin();
	}

	@Bean
	public DmnEngine dmnEngine() {
		return DmnEngineConfiguration.createDefaultDmnEngineConfiguration().buildEngine();
	}
}
