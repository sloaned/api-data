package assessment.utilities.DataPopulation;

import assessment.modules.User.User;
import assessment.modules.User.UserRepository;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by gfisher on 3/17/2016.
 */
@org.springframework.stereotype.Service
public class Service{

    @Autowired
    UserRepository userRepo;


    public void setRepo(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public void createUsers(Integer num) {
        for(int i = 0; i < num; i++){
            userRepo.save(new User("1", "Rick", "Bauer1", "email@email.com", "jbauer1", "Password"+num+"1!", "description", true));
        }
    }
}
