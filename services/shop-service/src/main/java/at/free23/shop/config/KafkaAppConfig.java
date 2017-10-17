/**
 *
 */
package at.free23.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class KafkaAppConfig {

	@Autowired
	private KafkaProperties kafkaProps;

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> jsonKafkaListenerContainerFactory() {
		final ConcurrentKafkaListenerContainerFactory<String, String> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		final DefaultKafkaConsumerFactory<String, String> cFactory = new DefaultKafkaConsumerFactory<>(
				this.kafkaProps.buildConsumerProperties());
		factory.setConsumerFactory(cFactory);
		factory.setMessageConverter(new StringJsonMessageConverter());
		return factory;
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		final DefaultKafkaProducerFactory<String, String> pFactory = new DefaultKafkaProducerFactory<>(
				this.kafkaProps.buildProducerProperties());
		final KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(pFactory);
		kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
		kafkaTemplate.setDefaultTopic(this.kafkaProps.getTemplate().getDefaultTopic());
		return kafkaTemplate;
	}

}
