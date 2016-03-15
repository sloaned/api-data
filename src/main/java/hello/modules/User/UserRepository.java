package hello.modules.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by gfisher on 3/14/2016.
 */
//@RepositoryRestResource(collectionResourceRel = "users", path = "users")
    @RepositoryRestResource()
public interface UserRepository extends MongoRepository<User, String> {
    /*
     * Prevents deletion of a user
     */
    @Override
    @RestResource(exported = false)
    void delete(User user);

    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
}
