package assessment.prepop.bootstrapping;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties for configuring the data to import
 * Can be used in application.properties/yml
 */
@ConfigurationProperties(prefix = "bootstrapping")
public class BootstrapDataProperties {

    private boolean users;
    private boolean kudos;
    private boolean teams;
    private boolean assessments;

    public boolean getUsers() {
        return users;
    }

    public boolean getKudos() {
        return kudos;
    }

    public boolean getTeams() {
        return teams;
    }

    public boolean getAssessments() { return assessments; }

    public void setUsers(boolean users) {
        this.users = users;
    }

    public void setKudos(boolean kudos) {
        this.kudos = kudos;
    }

    public void setTeams(boolean teams) {
        this.teams = teams;
    }

    public void setAssessments(boolean assessments) { this.assessments = assessments; }
}
