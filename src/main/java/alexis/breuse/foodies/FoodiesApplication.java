package alexis.breuse.foodies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoodiesApplication implements CommandLineRunner {

	@Autowired
	private FoodRepository foodRepository;

	public static void main(String[] args) {
		SpringApplication.run(FoodiesApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		foodRepository.deleteAll();

		foodRepository.save(new Food("Betterave", 50, 1, 20, 0, 2, 3, 3));
		foodRepository.save(new Food("Mais", 60, 10, 5, 2, 1, 4, 1));

		for (Food food : foodRepository.findAll())
			System.out.println(food);

		System.out.println(foodRepository.findByName("Betterave"));
		System.out.println(foodRepository.findByName("Mais"));
		System.out.println(foodRepository.findByName("Poule"));
	}
}
