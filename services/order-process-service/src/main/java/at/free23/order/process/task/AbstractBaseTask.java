/**
 *
 */
package at.free23.order.process.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.client.RestTemplate;

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

	@Override
	public abstract void execute(DelegateExecution exec) throws Exception;

}
