package assessment.prepop.employeeimport;

import assessment.entities.user.User;
import assessment.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * A User controller that had to be manually made since
 * I couldn't figure out how to get the UserRepository to
 * do a delete all
 */
@RestController
public class ImportUsersController {

    @Autowired
    private UserRepository repo;

    public UserRepository getRepo() {
        return repo;
    }

    public void setRepo(UserRepository repo) {
        this.repo = repo;
    }

    @RequestMapping(value = "/users/employeeimport", method = RequestMethod.POST)
    public List<User> importUsers(@RequestBody List<User> users) {
        repo.deleteAll();
        return repo.save(users);
    }
}
