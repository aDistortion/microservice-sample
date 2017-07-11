/**
 *
 */
package at.free23.order.process.task;

import java.io.IOException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.engine.variable.value.ObjectValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author michael.vlasaty
 *
 */
public abstract class AbstractBaseTask implements JavaDelegate {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected KafkaTemplate<String, ?> kafkaTemplate;

	@Autowired
	protected RestTemplate restTemplate;

	@Autowired
	private ObjectMapper mapper;

	@Override
	public abstract void execute(DelegateExecution exec) throws Exception;

	protected <T> T getVariable(String key, DelegateExecution exec, Class<T> type)
			throws JsonParseException, JsonMappingException, IOException {
		final ObjectValue orderVal = exec.getVariableTyped("order");
		return this.mapper.readValue(orderVal.getValueSerialized(), type);
	}

	protected ObjectValue createVariable(Object obj) {
		return Variables.objectValue(obj).serializationDataFormat("application/json").create();
	}
}
