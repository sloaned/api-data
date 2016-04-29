package assessment;

import assessment.configuration.BootstrapData;
import assessment.entities.kudo.Kudo;
import assessment.modules.kudo.KudoRepository;
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
    BootstrapData bootStrapData;

    public void setKudoRepo(KudoRepository kudoRepo) {
            this.kudoRepo = kudoRepo;
        }

    @RequestMapping(value = "/testDataInsert", method = RequestMethod.POST)
    public boolean insertTestData() {
        boolean success = false;

        boolean kudoSuccess = insertKudoData();

        if(kudoSuccess){

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
}


