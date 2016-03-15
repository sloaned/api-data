package hello.configuration;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;


import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;


/**
 * Created by gfisher on 3/15/2016.
 */
@Configuration
public class BeanValidator implements InitializingBean{

    private Validator validator;

    public void afterPropertiesSet() throws Exception {

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();

        validator = validatorFactory.usingContext().getValidator();

    }

    public boolean supports(Class clazz) {

        return true;

    }


    public void validate(Object target, Errors errors) {
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target);
        for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
            String propertyPath = constraintViolation.getPropertyPath().toString();
            String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }
    }
}
