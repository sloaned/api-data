package assessment.configuration;

import assessment.entities.assessment.Assessment;
import assessment.entities.question.Question;
import assessment.entities.review.Review;
import assessment.entities.team.Team;
import assessment.entities.user.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Assessment.class);
        config.exposeIdsFor(Question.class);
        config.exposeIdsFor(Review.class);
        config.exposeIdsFor(Team.class);
        config.exposeIdsFor(User.class);
    }
}