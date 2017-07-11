/**
 * 
 */
package at.free23.order.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import at.free23.order.api.TransactionPayload;
import at.free23.order.api.TransactionPayloadDeserializer;

/**
 * @author michael.vlasaty
 *
 */
@Configuration
public class KafkaAppConfig {
	
	@Autowired
	private KafkaProperties kafkaProps;
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, TransactionPayload> jsonKafkaListenerContainerFactory(TransactionPayloadDeserializer deserializer) {
		final ConcurrentKafkaListenerContainerFactory<String, TransactionPayload> factory =
				new ConcurrentKafkaListenerContainerFactory<>();
		
		final DefaultKafkaConsumerFactory<String, TransactionPayload> cFactory = new DefaultKafkaConsumerFactory<>(this.kafkaProps.buildConsumerProperties());
		cFactory.setKeyDeserializer(new StringDeserializer());
		cFactory.setValueDeserializer(deserializer);
		factory.setConsumerFactory(cFactory);
		return factory;
	}
	
	@Bean
	public KafkaTemplate<String, TransactionPayload> kafkaTemplate(ObjectMapper mapper) {
		final DefaultKafkaProducerFactory<String, TransactionPayload> pFactory = new DefaultKafkaProducerFactory<>(this.kafkaProps.buildProducerProperties());
		pFactory.setKeySerializer(new StringSerializer());
		pFactory.setValueSerializer(new JsonSerializer<TransactionPayload>(mapper));
		
		final KafkaTemplate<String, TransactionPayload> kafkaTemplate = new KafkaTemplate<>(pFactory);
		kafkaTemplate.setDefaultTopic(this.kafkaProps.getTemplate().getDefaultTopic());
		return kafkaTemplate;
	}
	
}
