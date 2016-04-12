package assessment.configuration;

import assessment.entities.user.Role;
import assessment.entities.user.User;
import assessment.modules.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hmccardell on 3/16/2016.
 */

@Configuration
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private UserRepository repository;


    //TODO: Create a better way to seed the database, probably through the service layer. Remove this function when that works
    /**
     * This automatically deletes any data, then repopulates the database with 25 users.
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        repository.deleteAll();
        int initData = 25;

        User user = new User();

        user.setVersion(1);
        user.setIsActive(true);
        user.setAvatar("avatar");
        user.setEmail("test@test.com");
        user.setFirstName("testFirstName");
        user.setLastName("testLastName");
        user.setRole(Role.DEVELOPER);
        user.setProfileDescription("Test description");

        User user2 = new User();

        user2.setVersion(1);
        user2.setIsActive(true);
        user2.setAvatar("avatar2");
        user2.setEmail("test2@test.com");
        user2.setFirstName("testFirstNameTwo");
        user2.setLastName("testLastNameTwo");
        user2.setRole(Role.DEVELOPER);
        user2.setProfileDescription("Test description2");


        repository.save(user);
        repository.save(user2);

    }

}
