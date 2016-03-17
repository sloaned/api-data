package assessment.utilities.DataPopulation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gfisher on 3/17/2016.
 */
@RestController
public class Controller {

    @Autowired
    protected Service service;


    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping(value="/createUser/{number}", method = RequestMethod.POST)
    public void createNewUsers(@PathVariable Integer number) {
        service.createUsers(number);
    }
}
