package pl.kopka.nutritioncalculator.repository;

import org.springframework.stereotype.Repository;
import pl.kopka.nutritioncalculator.model.Ingredient;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NutritionRepo {

    private List<Ingredient> ingredients = new ArrayList<>();

    public List<Ingredient> getAll() {
        return ingredients;
    }

    public List<Ingredient> add(Ingredient ingredient) {
        ingredients.add(ingredient);
        return ingredients;
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
