package assessment.modules.token;

import assessment.entities.token.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by gfisher on 3/16/2016.
 */
@RepositoryRestResource
public interface TokenRepository extends MongoRepository<Token,String> {

    @Override
    @RestResource(exported = false)
    void delete(Token token);
}
