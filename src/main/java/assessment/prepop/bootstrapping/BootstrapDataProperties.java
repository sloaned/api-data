package assessment.prepop.bootstrapping;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties for configuring the data to import
 * Can be used in application.properties/yml
 */
@ConfigurationProperties(prefix = "bootstrapping")
public class BootstrapDataProperties {

    private boolean kudos;
    private boolean teams;
    private boolean templates;
    private boolean questions;
    private boolean periods;
    private boolean reviews;

    public boolean getKudos() {
        return kudos;
    }

    public boolean getTeams() {
        return teams;
    }

    public boolean getTemplates() { return templates; }

    public boolean getQuestions() { return questions; }

    public boolean getPeriods() { return periods; }

    public boolean getReviews() { return reviews; }

    public void setKudos(boolean kudos) {
        this.kudos = kudos;
    }

    public void setTeams(boolean teams) {
        this.teams = teams;
    }

    public void setTemplates(boolean templates) { this.templates = templates; }

    public void setQuestions(boolean questions) { this.questions = questions; }

    public void setPeriods(boolean periods) { this.periods = periods; }

    public void setReviews(boolean reviews) { this.reviews = reviews; }
}
