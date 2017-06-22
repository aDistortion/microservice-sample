/**
 * 
 */
package com.example.billing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class KafkaAppConfig {
	
	@Value("spring.kafka.template.default-value")
	private String defaultTopic;
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> jsonKafkaListenerContainerFactory(ConsumerFactory<String, String> consumerFactory) {
		ConcurrentKafkaListenerContainerFactory<String, String> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory);
		factory.setMessageConverter(new StringJsonMessageConverter());
		return factory;
	}
	
	@Bean
	public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
		KafkaTemplate<String, String> kafkaTemplate = new KafkaTemplate<>(producerFactory);
		kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
		kafkaTemplate.setDefaultTopic(this.defaultTopic);
		return kafkaTemplate;
	}
	
}
