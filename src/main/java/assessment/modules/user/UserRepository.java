package assessment.modules.user;

import assessment.entities.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by gfisher on 3/14/2016.
 */
@RepositoryRestResource
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Prevents deletion of a user entity
     */
    @Override
    @RestResource(exported = false)
    void delete(User user);
}
