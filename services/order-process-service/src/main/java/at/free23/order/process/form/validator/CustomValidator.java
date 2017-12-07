/**
 *
 */
package at.free23.order.process.form.validator;

import org.camunda.bpm.engine.impl.form.validator.FormFieldValidator;
import org.camunda.bpm.engine.impl.form.validator.FormFieldValidatorContext;
import org.springframework.stereotype.Component;

/**
 * @author michael.vlasaty
 *
 */
@Component
public class CustomValidator implements FormFieldValidator {

	/* (non-Javadoc)
	 * @see org.camunda.bpm.engine.impl.form.validator.FormFieldValidator#validate(java.lang.Object, org.camunda.bpm.engine.impl.form.validator.FormFieldValidatorContext)
	 */
	@Override
	public boolean validate(Object submittedValue, FormFieldValidatorContext validatorContext) {
		// TODO Auto-generated method stub
		return true;
	}

}
