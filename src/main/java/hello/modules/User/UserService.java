package hello.modules.User;

import hello.core.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by gfisher on 3/14/2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private UserValidator validator;

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public User addUser(User user) throws Exception {
        Boolean userIsValid = validator.validateUsr(user);
        if(userIsValid) {
                return repository.save(user);
        }
        else {
            Exception e = new Exception("User validation failed");
            throw e;
        }
    }

    public User updateUser(User user) throws Exception {
        Boolean userIsValid = validator.validateUsr(user);
        if(userIsValid) {
            return repository.save(user);
        }
        else {
            Exception e = new Exception("User validation failed");
            throw e;
        }
    }

    public List<User> searchUserByLastName(String lastName) {
        return repository.findByLastName(lastName);
    }
}
