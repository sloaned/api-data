package hello.configuration;

import hello.core.validators.UserValidator;
import hello.modules.User.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Validator;

/**
 * Created by gfisher on 3/14/2016.
 */
@Configuration
public class ValidationConfig {

    @Bean
    public Validator<User> beforeSaveUserValidator() {
        return new Validator<User>;
    }
}
