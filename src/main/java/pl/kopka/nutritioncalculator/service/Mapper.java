package pl.kopka.nutritioncalculator.service;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import pl.kopka.nutritioncalculator.client.model.Food;
import pl.kopka.nutritioncalculator.client.model.Foods;
import pl.kopka.nutritioncalculator.model.Ingredient;

@Service
public class Mapper {


    public Ingredient mapToIngredient(Foods foods) {
        Food food = foods.getFoods().get(0);

        Ingredient ingredient = new Ingredient();
        ingredient.setImgUrl(food.getPhoto().getThumb());
        ingredient.setFood(food.getFoodName());
        ingredient.setUnit(food.getServingUnit());
        ingredient.setCalories(food.getNfCalories());
        ingredient.setWeight(food.getServingWeightGrams());
        ingredient.setTotalFat(food.getNfTotalFat());
        ingredient.setCholesterol(food.getNfCholesterol());
        ingredient.setSodium(food.getNfSodium());
        ingredient.setPotassium(food.getNfPotassium());
        ingredient.setTotalCarbohydrates(food.getNfTotalCarbohydrate());
        ingredient.setProtein(food.getNfProtein());

        return ingredient;
    }
}
