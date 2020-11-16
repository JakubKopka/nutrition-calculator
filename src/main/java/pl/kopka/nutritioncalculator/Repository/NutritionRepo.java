package pl.kopka.nutritioncalculator.Repository;

import org.springframework.stereotype.Repository;
import pl.kopka.nutritioncalculator.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NutritionRepo {

    private List<Ingredient> ingredients;

    public NutritionRepo() {
        this.ingredients = new ArrayList<>();
    }

    public List<Ingredient> getAll() {
        return ingredients;
    }

    public void add(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void deleteAll() {
        ingredients = new ArrayList<>();
    }

    public boolean deleteById(Long id) {
        int a = ingredients.size();
        ingredients = ingredients.stream().filter(o -> !o.getId().equals(id)).collect(Collectors.toList());
        return a != ingredients.size();
    }
}
