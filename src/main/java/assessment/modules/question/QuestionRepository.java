package assessment.modules.question;

import assessment.entities.question.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by gfisher on 3/16/2016.
 */
@RepositoryRestResource
public interface QuestionRepository extends MongoRepository<Question,String> {

    @Override
    @RestResource(exported = false)
    void delete(Question question);
}
