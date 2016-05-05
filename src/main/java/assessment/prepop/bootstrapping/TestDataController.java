package assessment.prepop.bootstrapping;

import assessment.entities.period.Period;
import assessment.repositories.KudoRepository;
import assessment.repositories.PeriodRepository;
import assessment.repositories.TemplateRepository;
import assessment.entities.kudo.Kudo;
import assessment.entities.team.Team;
import assessment.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hmccardell on 4/29/2016.
 */
@RestController
public class TestDataController {

    @Autowired
    KudoRepository kudoRepo;

    @Autowired
    TeamRepository teamRepo;

    @Autowired
    TemplateRepository templateRepo;

    @Autowired
    PeriodRepository periodRepo;

    @Autowired
    BootstrapData bootStrapData;

    public void setKudoRepo(KudoRepository kudoRepo) {
            this.kudoRepo = kudoRepo;
        }

    @RequestMapping(value = "/testDataInsert", method = RequestMethod.POST)
    public boolean insertTestData() {
        boolean success = false;

        kudoRepo.deleteAll();
        teamRepo.deleteAll();
        periodRepo.deleteAll();

        boolean kudoSuccess = insertKudoData();
        boolean teamSuccess = insertTeamData();
        boolean periodSuccess = insertPeriodData();

        if(kudoSuccess && teamSuccess){

            success = true;

        }

        return success;
    }

    private boolean insertKudoData(){
        boolean success = true;

        List<Kudo> kudoList = bootStrapData.getTestKudos();
        if(kudoList.isEmpty()){
            return false;
        }

        success = !kudoRepo.save(bootStrapData.getTestKudos()).isEmpty();

        return success;
    }

    private boolean insertTeamData(){
        boolean success = true;

        List<Team> teamList = bootStrapData.getTestTeams();
        if(teamList.isEmpty()){
            return false;
        }

        success = !teamRepo.save(bootStrapData.getTestTeams()).isEmpty();

        return success;
    }

    private boolean insertPeriodData(){
        boolean success = true;

        List<Period> perioodList = bootStrapData.getTestPeriods();
        if(perioodList.isEmpty()){
            return false;
        }

        success = !periodRepo.save(bootStrapData.getTestPeriods()).isEmpty();
        return success;
    }

}


