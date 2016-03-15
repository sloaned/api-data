package hello.core.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by gfisher on 3/14/2016.
 */
public class BaseValidator implements Validator {
    /**
     * checks a given String against a given regular expression
     * @param str string to be checked
     * @param regex regular expression that defines requirements on given
     *              String
     * @return Boolean indicating success or failure
     */
    public Boolean validateStringByRegex(String str, String regex) {
        Boolean stringIsValid = str.matches(regex);
        return stringIsValid;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }

    @Override
    public void validate(Object o, Errors errors) {

    }
}
