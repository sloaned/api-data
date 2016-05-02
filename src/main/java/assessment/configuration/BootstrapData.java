package assessment.configuration;

import assessment.entities.kudo.Kudo;
import assessment.entities.membership.Membership;
import assessment.entities.team.Team;
import assessment.entities.team.TeamType;
import assessment.entities.user.User;
import assessment.modules.team.TeamRepository;
import assessment.modules.user.UserRepository;
import assessment.util.SeedDataConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    @Autowired
    private TeamRepository teamRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserInListByEmail(String emailToFind, List<User> userList){

        for(int i = 0; i < userList.size(); i++){
            User userToFind = userList.get(i);
            if(userToFind.getEmail().equals(emailToFind)){
                return userToFind;
            }
        }
        return null;
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

    public List<Team> getTestTeams(){

        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();
        List<Team> teamList = new ArrayList<>();
        List<Membership> team1LeaderList = new ArrayList<>();
        List<Membership> team1DevList = new ArrayList<>();

        User hayes = findUserInListByEmail("hmccardell@catalystdevworks.com", userList);
        Membership hayesMembership = new Membership(hayes.getId(), true, new Date(), null);
        team1LeaderList.add(hayesMembership);

        User andrew = findUserInListByEmail("arajigah@catalystdevworks.com", userList);
        Membership andrewMembership = new Membership(andrew.getId(), true, new Date(), null);
        team1DevList.add(andrewMembership);

        User josh = findUserInListByEmail("jtucker@catalystdevworks.com", userList);
        Membership joshMembership = new Membership(josh.getId(), true, new Date(), null);
        team1DevList.add(joshMembership);

        User jacobson = findUserInListByEmail("jjacobson@catalystdevworks.com", userList);
        Membership jacobsonMembership = new Membership(jacobson.getId(), true, new Date(), null);
        team1DevList.add(jacobsonMembership);

        User marissa = findUserInListByEmail("mmosley@catalystdevworks.com", userList);
        Membership marissaMembership = new Membership(marissa.getId(), true, new Date(), null);
        team1DevList.add(marissaMembership);

        User gokul = findUserInListByEmail("gcaushik@catalystdevworks.com", userList);
        Membership gokulMembership = new Membership(gokul.getId(), true, new Date(), null);
        team1DevList.add(gokulMembership);

        User ben = findUserInListByEmail("bthomson@catalystdevworks.com", userList);
        Membership benMembership = new Membership(ben.getId(), true, new Date(), null);
        team1DevList.add(benMembership);

        User adam = findUserInListByEmail("afields@catalystdevworks.com", userList);
        Membership adamMembership = new Membership(adam.getId(), true, new Date(), null);
        team1DevList.add(adamMembership);

        User katy = findUserInListByEmail("klafrance@catalystdevworks.com", userList);
        Membership katyMembership = new Membership(katy.getId(), true, new Date(), null);
        team1DevList.add(katyMembership);

        User brent = findUserInListByEmail("blotspeich@catalystdevworks.com", userList);
        Membership brentMembership = new Membership(brent.getId(), false, new Date(), new Date());
        team1DevList.add(brentMembership);

        User greg = findUserInListByEmail("gfisher@catalystdevworks.com", userList);
        Membership gregMembership = new Membership(greg.getId(), false, new Date(), new Date());
        team1DevList.add(gregMembership);

        User alysha = findUserInListByEmail("arecore@catalystdevworks.com", userList);
        Membership alyshaMembership = new Membership(alysha.getId(), false, new Date(), new Date());
        team1DevList.add(alyshaMembership);

        User ken = findUserInListByEmail("kwheatt@catalystdevworks.com", userList);
        Membership kenMembership = new Membership(ken.getId(), false, new Date(), new Date());
        team1DevList.add(kenMembership);

        Team team1 = new Team();

        team1.setName("Hayes' Heroes");
        team1.setActive(true);
        team1.setDescription("A team of cycle 11 and 13 graduates dedicated to full stack awesomeness.");
        team1.setTeamType(TeamType.DEV);
        team1.setReviewFrequency(1);
        team1.setVersion(1);
        team1.setLeaderList(team1LeaderList);
        team1.setUserList(team1DevList);

        teamList.add(team1);

        return teamList;
    }
}
