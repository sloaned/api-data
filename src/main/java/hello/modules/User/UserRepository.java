package hello.modules.User;

import org.springframework.data.mongodb.repository.MongoRepository;
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

    /**
     * Provides an endpoint to search for Users by last name
     * @param lastName The last name of a user
     * @return List of all users with the given last name
     */
    public List<User> findByLastName(String lastName);
}
