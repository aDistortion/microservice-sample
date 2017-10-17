/**
 *
 */
package at.free23.order.process.task;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class SendEmailNotification extends AbstractBaseTask {

	/* (non-Javadoc)
	 * @see at.free23.order.process.task.AbstractBaseTask#execute(org.camunda.bpm.engine.delegate.DelegateExecution)
	 */
	@Override
	public void execute(DelegateExecution exec) throws Exception {
		// TODO Auto-generated method stub

	}

}
