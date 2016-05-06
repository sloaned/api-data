package assessment.prepop.bootstrapping;

import assessment.entities.kudo.Kudo;
import assessment.entities.period.Period;
import assessment.entities.team.Member;
import assessment.entities.team.Role;
import assessment.entities.team.Team;
import assessment.entities.user.User;
import assessment.repositories.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by hmccardell on 3/16/2016.
 */
@Component
@EnableConfigurationProperties(BootstrapDataProperties.class)
public class BootstrapData{

    @Autowired(required = false)
    private BootstrapDataProperties properties;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private TemplateRepository templateRepository;

    @Autowired
    private KudoRepository kudoRepository;

    protected Logger logger = LogManager.getLogger(this.getClass());

    @PostConstruct
    public void dataInsertion(){


        if (properties.getKudos()){
            kudoRepository.deleteAll();
            List<Kudo> kudoList = getTestKudos();
            kudoRepository.save(kudoList);
            logger.info("Kudos wiped and inserted");
        }
        else{
            logger.info("Kudos false, no manipulation");
        }
        if (properties.getTeams()){
            teamRepository.deleteAll();
            List<Team> teamList = getTestTeams();
            teamRepository.save(teamList);
            logger.info("Teams wiped and inserted");
        }
        else{
            logger.info("Teams false, no manipulation");
        }
        if (properties.getAssessments()){

        }

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

    public List<Kudo> getTestKudos() {

        List<User> userList = new ArrayList<>();
        userList = userRepository.findAll();

        User user1 = userList.get(1);
        User user2 = userList.get(2);

        Kudo kudo1 = new Kudo(user1.getId(), user2.getId(), Constants.KUDO_COMMENT_1, new Date());
        Kudo kudo2 = new Kudo(user1.getId(), user2.getId(), Constants.KUDO_COMMENT_2, new Date());
        Kudo kudo3 = new Kudo(user1.getId(), user2.getId(), Constants.KUDO_COMMENT_3, new Date());
        Kudo kudo4 = new Kudo(user1.getId(), user2.getId(), Constants.KUDO_COMMENT_4, new Date());
        Kudo kudo5 = new Kudo(user1.getId(), user2.getId(), Constants.KUDO_COMMENT_5, new Date());

        User user3 = userList.get(3);
        User user4 = userList.get(4);

        Kudo kudo6 = new Kudo(user3.getId(), user4.getId(), Constants.KUDO_COMMENT_1, new Date());
        Kudo kudo7 = new Kudo(user3.getId(), user4.getId(), Constants.KUDO_COMMENT_2, new Date());
        Kudo kudo8 = new Kudo(user3.getId(), user4.getId(), Constants.KUDO_COMMENT_3, new Date());
        Kudo kudo9 = new Kudo(user3.getId(), user4.getId(), Constants.KUDO_COMMENT_4, new Date());
        Kudo kudo10 = new Kudo(user3.getId(), user4.getId(), Constants.KUDO_COMMENT_5, new Date());

        User user5 = userList.get(5);
        User user6 = userList.get(6);

        Kudo kudo11 = new Kudo(user5.getId(), user6.getId(), Constants.KUDO_COMMENT_1, new Date());
        Kudo kudo12 = new Kudo(user5.getId(), user6.getId(), Constants.KUDO_COMMENT_2, new Date());
        Kudo kudo13 = new Kudo(user5.getId(), user6.getId(), Constants.KUDO_COMMENT_3, new Date());
        Kudo kudo14 = new Kudo(user5.getId(), user6.getId(), Constants.KUDO_COMMENT_4, new Date());
        Kudo kudo15 = new Kudo(user5.getId(), user6.getId(), Constants.KUDO_COMMENT_5, new Date());

        User user7 = userList.get(7);
        User user8 = userList.get(8);

        Kudo kudo17 = new Kudo(user7.getId(), user8.getId(), Constants.KUDO_COMMENT_2, new Date());
        Kudo kudo16 = new Kudo(user7.getId(), user8.getId(), Constants.KUDO_COMMENT_1, new Date());
        Kudo kudo18 = new Kudo(user7.getId(), user8.getId(), Constants.KUDO_COMMENT_3, new Date());
        Kudo kudo19 = new Kudo(user7.getId(), user8.getId(), Constants.KUDO_COMMENT_4, new Date());
        Kudo kudo20 = new Kudo(user7.getId(), user8.getId(), Constants.KUDO_COMMENT_5, new Date());

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
        List<Member> team1DevList = new ArrayList<>();

        User hayes = findUserInListByEmail("hmccardell@catalystdevworks.com", userList);
        Member hayesMember = new Member(hayes.getId(), true, new Date(), null, Role.LEAD);
        team1DevList.add(hayesMember);

        User andrew = findUserInListByEmail("arajigah@catalystdevworks.com", userList);
        Member andrewMember = new Member(andrew.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(andrewMember);

        User josh = findUserInListByEmail("jtucker@catalystdevworks.com", userList);
        Member joshMember = new Member(josh.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(joshMember);

        User jacobson = findUserInListByEmail("jjacobson@catalystdevworks.com", userList);
        Member jacobsonMember = new Member(jacobson.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(jacobsonMember);

        User marissa = findUserInListByEmail("mmosley@catalystdevworks.com", userList);
        Member marissaMember = new Member(marissa.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(marissaMember);

        User gokul = findUserInListByEmail("gcaushik@catalystdevworks.com", userList);
        Member gokulMember = new Member(gokul.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(gokulMember);

        User ben = findUserInListByEmail("bthomson@catalystdevworks.com", userList);
        Member benMember = new Member(ben.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(benMember);

        User adam = findUserInListByEmail("afields@catalystdevworks.com", userList);
        Member adamMember = new Member(adam.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(adamMember);

        User katy = findUserInListByEmail("klafrance@catalystdevworks.com", userList);
        Member katyMember = new Member(katy.getId(), true, new Date(), null, Role.DEVELOPER);
        team1DevList.add(katyMember);

        User brent = findUserInListByEmail("blotspeich@catalystdevworks.com", userList);
        Member brentMember = new Member(brent.getId(), false, new Date(), new Date(), Role.DEVELOPER);
        team1DevList.add(brentMember);

        User greg = findUserInListByEmail("gfisher@catalystdevworks.com", userList);
        Member gregMember = new Member(greg.getId(), false, new Date(), new Date(), Role.DEVELOPER);
        team1DevList.add(gregMember);

        User alysha = findUserInListByEmail("arecore@catalystdevworks.com", userList);
        Member alyshaMember = new Member(alysha.getId(), false, new Date(), new Date(), Role.DEVELOPER);
        team1DevList.add(alyshaMember);

        User ken = findUserInListByEmail("kwheatt@catalystdevworks.com", userList);
        Member kenMember = new Member(ken.getId(), false, new Date(), new Date(), Role.DEVELOPER);
        team1DevList.add(kenMember);

        Team team1 = new Team();

        team1.setName("Hayes' Heroes");
        team1.setIsActive(true);
        team1.setDescription("A team of cycle 11 and 13 graduates dedicated to full stack awesomeness.");
        team1.setVersion(1);
        team1.setMemberList(team1DevList);
        team1.setSummaryScore(4.0);
        teamList.add(team1);

        return teamList;
    }

    public List<Period> getTestPeriods(){

        Period period = new Period();



        List<Period> periodList = new ArrayList<>();
        return periodList;
    }
}
