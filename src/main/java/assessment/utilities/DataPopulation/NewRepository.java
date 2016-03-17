package assessment.utilities.DataPopulation;

import assessment.modules.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by gfisher on 3/17/2016.
 */
@Repository
public interface NewRepository extends MongoRepository<User, String> {

}
