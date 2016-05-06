package assessment.repositories;

import assessment.entities.kudo.Kudo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by hmccardell on 4/29/2016.
 */
@RepositoryRestResource(path ="/kudos")
public interface KudoRepository extends MongoRepository<Kudo,String> {

    @Override
    @RestResource(exported = false)
    void delete(Kudo kudo);

}
