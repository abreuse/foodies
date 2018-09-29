package alexis.breuse.foodies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
