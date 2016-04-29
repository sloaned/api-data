package assessment.configuration;

import assessment.entities.kudo.Kudo;
import assessment.entities.user.User;
import assessment.modules.user.UserRepository;
import assessment.util.SeedDataConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hmccardell on 3/16/2016.
 */

@Component
public class BootstrapData{

    @Autowired
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public List<Kudo> getTestKudos() {

        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();

        User user1 = userList.get(1);
        User user2 = userList.get(2);

        Kudo kudo1 = new Kudo(1, user1.getId(), user2.getId(), SeedDataConstants.KUDO_COMMENT_1, new Date());
        Kudo kudo2 = new Kudo(1, user1.getId(), user2.getId(), SeedDataConstants.KUDO_COMMENT_2, new Date());
        Kudo kudo3 = new Kudo(1, user1.getId(), user2.getId(), SeedDataConstants.KUDO_COMMENT_3, new Date());
        Kudo kudo4 = new Kudo(1, user1.getId(), user2.getId(), SeedDataConstants.KUDO_COMMENT_4, new Date());
        Kudo kudo5 = new Kudo(1, user1.getId(), user2.getId(), SeedDataConstants.KUDO_COMMENT_5, new Date());

        User user3 = userList.get(3);
        User user4 = userList.get(4);

        Kudo kudo6 = new Kudo(1, user3.getId(), user4.getId(), SeedDataConstants.KUDO_COMMENT_1, new Date());
        Kudo kudo7 = new Kudo(1, user3.getId(), user4.getId(), SeedDataConstants.KUDO_COMMENT_2, new Date());
        Kudo kudo8 = new Kudo(1, user3.getId(), user4.getId(), SeedDataConstants.KUDO_COMMENT_3, new Date());
        Kudo kudo9 = new Kudo(1, user3.getId(), user4.getId(), SeedDataConstants.KUDO_COMMENT_4, new Date());
        Kudo kudo10 = new Kudo(1, user3.getId(), user4.getId(), SeedDataConstants.KUDO_COMMENT_5, new Date());

        User user5 = userList.get(5);
        User user6 = userList.get(6);

        Kudo kudo11 = new Kudo(1, user5.getId(), user6.getId(), SeedDataConstants.KUDO_COMMENT_1, new Date());
        Kudo kudo12 = new Kudo(1, user5.getId(), user6.getId(), SeedDataConstants.KUDO_COMMENT_2, new Date());
        Kudo kudo13 = new Kudo(1, user5.getId(), user6.getId(), SeedDataConstants.KUDO_COMMENT_3, new Date());
        Kudo kudo14 = new Kudo(1, user5.getId(), user6.getId(), SeedDataConstants.KUDO_COMMENT_4, new Date());
        Kudo kudo15 = new Kudo(1, user5.getId(), user6.getId(), SeedDataConstants.KUDO_COMMENT_5, new Date());

        User user7 = userList.get(7);
        User user8 = userList.get(8);

        Kudo kudo17 = new Kudo(1, user7.getId(), user8.getId(), SeedDataConstants.KUDO_COMMENT_2, new Date());
        Kudo kudo16 = new Kudo(1, user7.getId(), user8.getId(), SeedDataConstants.KUDO_COMMENT_1, new Date());
        Kudo kudo18 = new Kudo(1, user7.getId(), user8.getId(), SeedDataConstants.KUDO_COMMENT_3, new Date());
        Kudo kudo19 = new Kudo(1, user7.getId(), user8.getId(), SeedDataConstants.KUDO_COMMENT_4, new Date());
        Kudo kudo20 = new Kudo(1, user7.getId(), user8.getId(), SeedDataConstants.KUDO_COMMENT_5, new Date());

        List<Kudo> kudoList = new ArrayList<>();

        kudoList.add(kudo1);
        kudoList.add(kudo2);
        kudoList.add(kudo3);
        kudoList.add(kudo4);
        kudoList.add(kudo5);
        kudoList.add(kudo6);
        kudoList.add(kudo7);
        kudoList.add(kudo8);
        kudoList.add(kudo9);
        kudoList.add(kudo10);
        kudoList.add(kudo11);
        kudoList.add(kudo12);
        kudoList.add(kudo13);
        kudoList.add(kudo14);
        kudoList.add(kudo15);
        kudoList.add(kudo16);
        kudoList.add(kudo17);
        kudoList.add(kudo18);
        kudoList.add(kudo19);
        kudoList.add(kudo20);

        return kudoList;
    }
}
