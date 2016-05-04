package assessment.modules;

import assessment.entities.period.Period;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by hmccardell on 5/4/2016.
 */
public interface PeriodRepository extends MongoRepository<Period,String> {

    @Override
    @RestResource(exported = false)
    void delete(Period period);

}
