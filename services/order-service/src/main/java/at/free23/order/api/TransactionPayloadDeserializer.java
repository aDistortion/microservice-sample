/**
 * 
 */
package at.free23.order.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class TransactionPayloadDeserializer extends JsonDeserializer<TransactionPayload>{

	@Autowired
	public TransactionPayloadDeserializer(ObjectMapper mapper){
		super(TransactionPayload.class, mapper);
	}
}
