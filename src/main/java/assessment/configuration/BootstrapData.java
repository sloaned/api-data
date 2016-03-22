package assessment.configuration;

import assessment.modules.User.User;
import assessment.modules.User.UserRepository;
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

        for(int i = 0; i < initData; i++) {
            repository.save(new User("1", "Jack", "Bauer"+i, "email@email.com", "jbauer"+i, "Password!"+i, "description", true));
        }
    }


}
