package assessment.prepop.bootstrapping;

import assessment.entities.feedback.Feedback;
import assessment.entities.kudo.Kudo;
import assessment.entities.period.Period;
import assessment.entities.question.Question;
import assessment.entities.question.QuestionType;
import assessment.entities.review.Review;
import assessment.entities.team.Member;
import assessment.entities.team.Role;
import assessment.entities.team.Team;
import assessment.entities.template.Template;
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

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    List<User> userList;

    protected Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Void method for saving the test data to the database.  Other methods in this class
     * return lists which are persisted here.  This method checks the BootstrapData properties
     * file, and if the related switch is true, the method clears the current data from that
     * repository and persists the test data.
     */
    @PostConstruct
    public void dataInsertion(){

        if(getUserList().isEmpty()){
            logger.error("No users found, testing data not inserted.");
            return;
        }

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

        if (properties.getQuestions()){
            questionRepository.deleteAll();
            List<Question> questionList = getTestQuestions();
            questionRepository.save(questionList);
            logger.info("Questions wiped and inserted");
        }
        else{
            logger.info("Questions false, no manipulation");
        }

        if (properties.getTemplates()){
            templateRepository.deleteAll();
            List<Template> templateList = getTestTemplates();
            templateRepository.save(templateList);
            logger.info("Templates wiped and inserted");
        }
        else{
            logger.info("Templates false, no manipulation");
        }

        if (properties.getPeriods()){
            periodRepository.deleteAll();
            List<Period> periodList = getTestPeriods();
            periodRepository.save(periodList);
            logger.info("Periods wiped and inserted");
        }
        else{
            logger.info("Periods false, no manipulation");
        }


        if (properties.getReviews()){
            reviewRepository.deleteAll();
            List<Review> reviewList = getTestReviews();
            reviewRepository.save(reviewList);
            logger.info("Reviews wiped and inserted");
        }
        else{
            logger.info("Reviews false, no manipulation");
        }

    }

    public List<User> getUserList(){

        if(userList == null){
            userList = userRepository.findAll();
        }

        return userList;
    }


    /**
     * Searches a list for a user by email address.
     * @return the user object if it exists in the list, or null if it does not
     */
    public User findUserInListByEmail(String emailToFind, List<User> userList){

        for(int i = 0; i < userList.size(); i++){
            User userToFind = userList.get(i);
            if(userToFind.getEmail().equals(emailToFind)){
                return userToFind;
            }
        }
        return null;
    }

    /**
     * Searches a list for a template by name.
     * @return the template object if it exists in the list, or null if it does not
     */
    public Template findTemplateInListByName(String emailToFind, List<Template> templateList){

        for(int i = 0; i < templateList.size(); i++){
            Template templateToReturn = templateList.get(i);
            if(templateToReturn.getName().equals(emailToFind)){
                return templateToReturn;
            }
        }
        return null;
    }


    /**
     * Constructs 5 kudos and associates them with several different users from the employee database
     * @return a list of kudos
     */
    public List<Kudo> getTestKudos() {

        userList = getUserList();

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

    /**
     * Constructs test data for several teams
     * @return a list of teams for testing purposes
     */
    public List<Team> getTestTeams(){

        List<User> userList = getUserList();
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

        List<Member> team2DevList = new ArrayList<>();

        User dan = findUserInListByEmail("dreuther@catalystdevworks.com", userList);
        Member danMember = new Member(dan.getId(), true, new Date(), null, Role.LEAD);
        team2DevList.add(danMember);

        User cole = findUserInListByEmail("chatley@catalystdevworks.com", userList);
        Member coleMember = new Member(cole.getId(), true, new Date(), null, Role.DEVELOPER);
        team2DevList.add(coleMember);

        Team team2 = new Team();
        team2.setName("KCLS");
        team2.setIsActive(false);
        team2.setDescription("Perl enthusiasts.");
        team2.setVersion(1);
        team2.setMemberList(team2DevList);
        team2.setSummaryScore(3.0);

        List<Member> team3DevList = new ArrayList<>();

        User jules = findUserInListByEmail("jespinosa@catalystdevworks.com", userList);
        Member julesMember = new Member(jules.getId(), true, new Date(), null, Role.LEAD);
        team3DevList.add(julesMember);

        User jake = findUserInListByEmail("jmiller@catalystdevworks.com", userList);
        Member jakeMember = new Member(jake.getId(), true, new Date(), null, Role.DEVELOPER);
        team3DevList.add(jakeMember);

        User sloane = findUserInListByEmail("dsloane@catalystdevworks.com", userList);
        Member sloaneMember = new Member(sloane.getId(), true, new Date(), null, Role.DEVELOPER);
        team3DevList.add(sloaneMember);

        Team team3 = new Team();
        team3.setName("ATA Mobile");
        team3.setIsActive(true);
        team3.setDescription("They're mobile.");
        team3.setVersion(1);
        team3.setMemberList(team3DevList);
        team3.setSummaryScore(4.0);

        teamList.add(team1);
        teamList.add(team2);
        teamList.add(team3);

        return teamList;
    }

    /**
     * Constructs test data for periods
     * @return a list of periods for testing purposes
     */
    public List<Period> getTestPeriods(){
        Period period1 = new Period();
        List<Template> templateList = templateRepository.findAll();
        Template competencyTemplate = findTemplateInListByName("Core Competencies", templateList);
        Team team1 = teamRepository.findByName("Hayes' Heroes");

        period1.setTemplateId(competencyTemplate.getId());
        period1.setName("Why are we naming periods");
        period1.setTeamId(team1.getId());
        period1.setSeriesNumber(1);
        period1.setDateTriggered((new Date()));
        period1.setSummaryScore(1.0);
        period1.setVersion(1);

        List<Period> periodList = new ArrayList<>();
        periodList.add(period1);
        return periodList;
    }

    /**
     * Constructs test data for templates
     * @return a list of templates for testing purposes
     */
    public List<Template> getTestTemplates(){
        List<Question> questionList = getTestQuestions();
        Template template1 = new Template("Core Competencies", questionList);

        List<Template> templateList = new ArrayList<>();
        templateList.add(template1);
        return templateList;

    }

    /**
     * Constructs test data for questions
     * @return a list of questions for testing purposes
     */
    public List<Question> getTestQuestions(){
        Question question1 = new Question(QuestionType.COMPETENCY, "How would you rate this developer's customer engagement?");
        Question question2 = new Question(QuestionType.COMPETENCY, "How would you rate this developer's technical depth and breadth?");
        Question question3 = new Question(QuestionType.COMPETENCY, "How would you rate this developer's leadership?");
        Question question4 = new Question(QuestionType.COMPETENCY, "How would you rate this developer's communication?");
        Question question5 = new Question(QuestionType.COMPETENCY, "How would you rate this developer's problem solving?");
        Question question6 = new Question(QuestionType.COMPETENCY, "How would you rate this developer's self-improvement and mentorship?");

        List<Question> questionList = new ArrayList<>();

        questionList.add(question1);
        questionList.add(question2);
        questionList.add(question3);
        questionList.add(question4);
        questionList.add(question5);
        questionList.add(question6);

        return questionList;
    }

    /**
     * Constructs test data for reviews
     * @return a list of reviews for testing purposes
     */
    public List<Review> getTestReviews(){
        List<Review> reviewList = new ArrayList<>();
        List<User> userList = getUserList();

        User sloane = findUserInListByEmail("dsloane@catalystdevworks.com", userList);
        User jake = findUserInListByEmail("jmiller@catalystdevworks.com", userList);
        User jules = findUserInListByEmail("jespinosa@catalystdevworks.com", userList);
        User cole = findUserInListByEmail("chatley@catalystdevworks.com", userList);
        User dan = findUserInListByEmail("dreuther@catalystdevworks.com", userList);
        User hayes = findUserInListByEmail("hmccardell@catalystdevworks.com", userList);
        User andrew = findUserInListByEmail("arajigah@catalystdevworks.com", userList);
        User josh = findUserInListByEmail("jtucker@catalystdevworks.com", userList);
        User jacobson = findUserInListByEmail("jjacobson@catalystdevworks.com", userList);
        User marissa = findUserInListByEmail("mmosley@catalystdevworks.com", userList);
        User gokul = findUserInListByEmail("gcaushik@catalystdevworks.com", userList);
        User ben = findUserInListByEmail("bthomson@catalystdevworks.com", userList);
        User adam = findUserInListByEmail("afields@catalystdevworks.com", userList);
        User katy = findUserInListByEmail("klafrance@catalystdevworks.com", userList);
        User brent = findUserInListByEmail("blotspeich@catalystdevworks.com", userList);
        User greg = findUserInListByEmail("gfisher@catalystdevworks.com", userList);
        User alysha = findUserInListByEmail("arecore@catalystdevworks.com", userList);
        User ken = findUserInListByEmail("kwheatt@catalystdevworks.com", userList);

        Feedback feedback11 = new Feedback("How would you rate this developer's customer engagement?", 1, "Comment");
        Feedback feedback12 = new Feedback("How would you rate this developer's technical depth and breadth?", 1, "Comment");
        Feedback feedback13 = new Feedback("How would you rate this developer's leadership?", 1, "Comment");
        Feedback feedback14 = new Feedback("How would you rate this developer's communication?", 1, "Comment");
        Feedback feedback15 = new Feedback("How would you rate this developer's problem solving?", 1, "Comment");
        Feedback feedback16 = new Feedback("How would you rate this developer's self-improvement and mentorship?", 1, "Comment");

        Feedback feedback41 = new Feedback("How would you rate this developer's customer engagement?", 4, "Customer engagement is great");
        Feedback feedback42 = new Feedback("How would you rate this developer's technical depth and breadth?", 4, "Very technical!");
        Feedback feedback43 = new Feedback("How would you rate this developer's leadership?", 4, "Leadership is great");
        Feedback feedback44 = new Feedback("How would you rate this developer's communication?", 4, "Communication is great");
        Feedback feedback45 = new Feedback("How would you rate this developer's problem solving?", 4, "Detailed description of problem solving abilities for an important issue on client project. Detailed description of problem solving abilities for an important issue on client project. Detailed description of problem solving abilities for an important issue on client project. Detailed description of problem solving abilities for an important issue on client project.");
        Feedback feedback46 = new Feedback("How would you rate this developer's self-improvement and mentorship?", 4, "Good mentoring skills.");

        List<Feedback> greatFeedbackList = new ArrayList<>();
        greatFeedbackList.add(feedback41);
        greatFeedbackList.add(feedback42);
        greatFeedbackList.add(feedback43);
        greatFeedbackList.add(feedback44);
        greatFeedbackList.add(feedback45);
        greatFeedbackList.add(feedback46);

        List<Feedback> badFeedbackList = new ArrayList<>();
        badFeedbackList.add(feedback11);
        badFeedbackList.add(feedback12);
        badFeedbackList.add(feedback13);
        badFeedbackList.add(feedback14);
        badFeedbackList.add(feedback15);
        badFeedbackList.add(feedback16);

        Date reviewDate = new Date(System.currentTimeMillis() + 60000);

        Review review_hayes1 = new Review(hayes.getId(), andrew.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_hayes2 = new Review(hayes.getId(), josh.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_hayes3 = new Review(hayes.getId(), jacobson.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_hayes4 = new Review(hayes.getId(), ben.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_hayes5 = new Review(hayes.getId(), gokul.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_hayes6 = new Review(hayes.getId(), marissa.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_andrew1 = new Review(andrew.getId(), hayes.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_andrew2 = new Review(andrew.getId(), josh.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_andrew3 = new Review(andrew.getId(), jacobson.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_andrew4 = new Review(andrew.getId(), ben.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_andrew5 = new Review(andrew.getId(), gokul.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_andrew6 = new Review(andrew.getId(), marissa.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_josh1 = new Review(josh.getId(), andrew.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_josh2 = new Review(josh.getId(), hayes.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_josh3 = new Review(josh.getId(), jacobson.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_josh4 = new Review(josh.getId(), ben.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_josh5 = new Review(josh.getId(), gokul.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_josh6 = new Review(josh.getId(), marissa.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_jacobson1 = new Review(jacobson.getId(), andrew.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_jacobson2 = new Review(jacobson.getId(), josh.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_jacobson3 = new Review(jacobson.getId(), hayes.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_jacobson4 = new Review(jacobson.getId(), ben.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_jacobson5 = new Review(jacobson.getId(), gokul.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_jacobson6 = new Review(jacobson.getId(), marissa.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_ben1 = new Review(ben.getId(), andrew.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_ben2 = new Review(ben.getId(), josh.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_ben3 = new Review(ben.getId(), jacobson.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_ben4 = new Review(ben.getId(), hayes.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_ben5 = new Review(ben.getId(), gokul.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_ben6 = new Review(ben.getId(), marissa.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_gokul1 = new Review(gokul.getId(), andrew.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_gokul2 = new Review(gokul.getId(), josh.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_gokul3 = new Review(gokul.getId(), jacobson.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_gokul4 = new Review(gokul.getId(), ben.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_gokul5 = new Review(gokul.getId(), hayes.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_gokul6 = new Review(gokul.getId(), marissa.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_marissa1 = new Review(marissa.getId(), andrew.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_marissa2 = new Review(marissa.getId(), josh.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_marissa3 = new Review(marissa.getId(), jacobson.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_marissa4 = new Review(marissa.getId(), ben.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_marissa5 = new Review(marissa.getId(), gokul.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");
        Review review_marissa6 = new Review(marissa.getId(), hayes.getId(), reviewDate, greatFeedbackList, 4.0, "Hayes' Heroes");

        Review review_dan1 = new Review(dan.getId(), cole.getId(), reviewDate, greatFeedbackList, 2.0, "KCLS");
        Review review_cole1 = new Review(cole.getId(), dan.getId(), reviewDate, badFeedbackList, 2.0, "KCLS");

        Review review_jules1 = new Review(jules.getId(), jake.getId(), reviewDate, badFeedbackList, 2.0, "ATA Mobile");
        Review review_jules2 = new Review(jules.getId(), sloane.getId(), reviewDate, badFeedbackList, 2.0, "ATA Mobile");

        Review review_jake1 = new Review(jake.getId(), jules.getId(), reviewDate, badFeedbackList, 2.0, "ATA Mobile");
        Review review_jake2 = new Review(jake.getId(), sloane.getId(), reviewDate, badFeedbackList, 2.0, "ATA Mobile");

        Review review_sloane1 = new Review(sloane.getId(), jules.getId(), reviewDate, badFeedbackList, 2.0, "ATA Mobile");
        Review review_sloane2 = new Review(sloane.getId(), jake.getId(), reviewDate, badFeedbackList, 2.0, "ATA Mobile");

        reviewList.add(review_dan1);
        reviewList.add(review_cole1);

        reviewList.add(review_jules1);
        reviewList.add(review_jules2);

        reviewList.add(review_jake1);
        reviewList.add(review_jake2);

        reviewList.add(review_sloane1);
        reviewList.add(review_sloane2);

        reviewList.add(review_hayes1);
        reviewList.add(review_hayes2);
        reviewList.add(review_hayes3);
        reviewList.add(review_hayes4);
        reviewList.add(review_hayes5);
        reviewList.add(review_hayes6);

        reviewList.add(review_andrew1);
        reviewList.add(review_andrew2);
        reviewList.add(review_andrew3);
        reviewList.add(review_andrew4);
        reviewList.add(review_andrew5);
        reviewList.add(review_andrew6);

        reviewList.add(review_josh1);
        reviewList.add(review_josh2);
        reviewList.add(review_josh3);
        reviewList.add(review_josh4);
        reviewList.add(review_josh5);
        reviewList.add(review_josh6);

        reviewList.add(review_jacobson1);
        reviewList.add(review_jacobson2);
        reviewList.add(review_jacobson3);
        reviewList.add(review_jacobson4);
        reviewList.add(review_jacobson5);
        reviewList.add(review_jacobson6);

        reviewList.add(review_ben1);
        reviewList.add(review_ben2);
        reviewList.add(review_ben3);
        reviewList.add(review_ben4);
        reviewList.add(review_ben5);
        reviewList.add(review_ben6);

        reviewList.add(review_gokul1);
        reviewList.add(review_gokul2);
        reviewList.add(review_gokul3);
        reviewList.add(review_gokul4);
        reviewList.add(review_gokul5);
        reviewList.add(review_gokul6);

        reviewList.add(review_marissa1);
        reviewList.add(review_marissa2);
        reviewList.add(review_marissa3);
        reviewList.add(review_marissa4);
        reviewList.add(review_marissa5);
        reviewList.add(review_marissa6);

        return reviewList;
    }

}
