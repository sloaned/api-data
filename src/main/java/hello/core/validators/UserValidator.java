package hello.core.validators;

import hello.core.utilities.RegexConstants;
import hello.modules.User.User;
import org.springframework.stereotype.Service;

/**
 * Created by gfisher on 3/14/2016.
 */
@Service
public class UserValidator extends BaseValidator {
    /**
     * checks if ALL attribute Strings for a given Usr are valid
     * @param user User object to validate
     * @return Boolean indicating whether or not ALL attribute Strings are
     * valid
     */
    public Boolean validateUsr(User user) {
        Boolean usrIsValid = false;
        String username = user.getUsername();
        String password = user.getPassword();
        String email = user.getEmail();
        if (validateUsername(username) && validatePassword(password)
                && validateEmail(email)) {
            usrIsValid = true;
        }
        return usrIsValid;
    }

    /**
     * checks if given String passes regex-defined requirements for username
     * @param username username to validate
     * @return Boolean indicating success or failure
     */
    public Boolean validateUsername(String username) {
        return validateStringByRegex(username, RegexConstants.USERNAME);
    }

    /**
     * checks if given String passes regex-defined requirements for user password
     * @param password password to validate
     * @return Boolean indicating success or failure
     */
    public Boolean validatePassword(String password) {
        return validateStringByRegex(password, RegexConstants.PASSWORD);
    }

    /**
     * checks if given String passes regex-defined requirements for email address
     * @param email email address to validate
     * @return Boolean indicating success or failure
     */
    public Boolean validateEmail(String email) {
        return validateStringByRegex(email, RegexConstants.EMAIL);
    }
}
