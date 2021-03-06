package alexis.breuse.foodies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping
    public ResponseEntity getFoodByName(@RequestParam(value = "search") String name) {
        if(name.equals(""))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("The 'search' parameter must have a value.");

        if(foodRepository.findByName(name) == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        return ResponseEntity.ok(foodRepository.findByName(name));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateFood(@PathVariable("id") String id, @RequestBody Food food) {
        if(!foodRepository.findById(id).isPresent())
            return ResponseEntity.notFound().build();

        Food foodEntity = foodRepository.findById(id).get();

        //update entity with fields of the JSON food

        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity postFood(@RequestBody Food food) throws URISyntaxException {
        if(food.getName() == null || food.getName().equals(""))
            return ResponseEntity.badRequest().body("Must have the property 'name'.");

        else if(food.getCalories() == 0)
            return ResponseEntity.badRequest().body("Must have the property 'calories'.");

        foodRepository.save(food);

        return ResponseEntity.created(new URI("localhost:8080/food?search=" + food.getName())).build();
    }



    @DeleteMapping("/{id}")
    public ResponseEntity deleteFood(@PathVariable("id") String id) {

        if(!foodRepository.findById(id).isPresent())
            return ResponseEntity.notFound().build();

        foodRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
