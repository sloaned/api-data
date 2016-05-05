package assessment.repositories;

import assessment.entities.review.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource
public interface ReviewRepository extends MongoRepository<Review, String> {

    @Override
    @RestResource(exported = false)
    void delete(Review review);
}
