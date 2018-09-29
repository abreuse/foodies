package alexis.breuse.foodies;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {

    Food findByName(String name);
}
