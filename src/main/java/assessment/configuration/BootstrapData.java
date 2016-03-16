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


    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        repository.save(new User("1", "Jack", "Bauer1", "email@email.com", "jbauer1", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer2", "email@email.com", "jbauer2", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer3", "email@email.com", "jbauer3", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer4", "email@email.com", "jbauer4", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer5", "email@email.com", "jbauer5", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer6", "email@email.com", "jbauer6", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer7", "email@email.com", "jbauer7", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer8", "email@email.com", "jbauer8", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer9", "email@email.com", "jbauer9", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer10", "email@email.com", "jbauer10", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer11", "email@email.com", "jbauer11", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer12", "email@email.com", "jbauer12", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer13", "email@email.com", "jbauer13", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer14", "email@email.com", "jbauer14", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer15", "email@email.com", "jbauer15", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer16", "email@email.com", "jbauer16", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer17", "email@email.com", "jbauer17", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer18", "email@email.com", "jbauer18", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer19", "email@email.com", "jbauer19", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer20", "email@email.com", "jbauer20", "Password1!", "description", true));
        repository.save(new User("1", "Jack", "Bauer21", "email@email.com", "jbauer21", "Password1!", "description", true));

    }


}
