package alexis.breuse.foodies;

import lombok.NoArgsConstructor;

import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@NoArgsConstructor
public class Food {

    public Food(String name, int calories, int prots, int carbs, int lipids,
                int sodium, int fibers, int sugar) {
        this.name = name;
        this.calories = calories;
        this.prots = prots;
        this.carbs = carbs;
        this.lipids = lipids;
        this.sodium = sodium;
        this.fibers = fibers;
        this.sugar = sugar;
    }

    @Id
    private String id;

    private String name;

    private int calories;

    private int prots;

    private int carbs;

    private int lipids;

    private int sodium;

    private int fibers;

    private int sugar;

    @Override
    public String toString() {
        return String.format("Food [id : %s, name : %s, prots : %d, carbs : %d, lipids : %d]", id, name, prots, carbs, lipids);
    }
}
