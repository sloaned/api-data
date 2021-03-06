package assessment.repositories;

import assessment.entities.template.Template;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by gfisher on 3/16/2016.
 */
@RepositoryRestResource
public interface TemplateRepository extends MongoRepository<Template, String> {

    @Override
    @RestResource(exported = false)
    void delete(Template assessment);
}
