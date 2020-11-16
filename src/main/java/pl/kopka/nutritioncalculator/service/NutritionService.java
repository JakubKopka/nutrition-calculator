package pl.kopka.nutritioncalculator.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.kopka.nutritioncalculator.Repository.NutritionRepo;
import pl.kopka.nutritioncalculator.client.ClientApi;
import pl.kopka.nutritioncalculator.client.model.ErrorApi;
import pl.kopka.nutritioncalculator.client.model.Foods;
import pl.kopka.nutritioncalculator.model.Ingredient;
import pl.kopka.nutritioncalculator.model.NewIngredient;
import pl.kopka.nutritioncalculator.model.SumIngredients;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class NutritionService {

    private ClientApi clientApi;
    private Mapper mapper;
    private NutritionRepo nutritionRepo;

    public NutritionService(ClientApi clientApi, Mapper mapper, NutritionRepo nutritionRepo) {
        this.clientApi = clientApi;
        this.mapper = mapper;
        this.nutritionRepo = nutritionRepo;
    }

    private String prepareQuery(NewIngredient ing) {
        return ing.getName() + " " + ing.getWeight() + ing.getUnit();
    }

    public List<Ingredient> getIngredientsInfo(NewIngredient ing) {
        String queryApi = prepareQuery(ing);
        ResponseEntity<Foods> responseEntity = clientApi.getInfo(queryApi);
        Ingredient ingredient = mapper.mapToIngredient(responseEntity.getBody());
        ingredient.setId(getNextId());
        return nutritionRepo.add(ingredient);
    }

    public Long getNextId() {
        Long id = 0L;
        List<Ingredient> ingredients = nutritionRepo.getAll();
        if (ingredients.size() > 0) {
            id = ingredients.get(ingredients.size() - 1).getId() + 1;
        }
        return id;
    }

    public List<Ingredient> getAllIngredients() {
        return nutritionRepo.getAll();
    }

    public SumIngredients getSummaryOfIngredients() {
        SumIngredients sumIngredients = new SumIngredients();
        List<Ingredient> ingredients = nutritionRepo.getAll();
        sumIngredients.setCalories(setPrecision(ingredients.stream().mapToDouble(o -> o.getCalories()).sum()));
        sumIngredients.setWeight(setPrecision(ingredients.stream().mapToDouble(o -> o.getWeight()).sum()));
        sumIngredients.setTotalFat(setPrecision(ingredients.stream().mapToDouble(o -> o.getTotalFat()).sum()));
        sumIngredients.setCholesterol(setPrecision(ingredients.stream().mapToDouble(o -> o.getCholesterol()).sum()));
        sumIngredients.setSodium(setPrecision(ingredients.stream().mapToDouble(o -> o.getSodium()).sum()));
        sumIngredients.setPotassium(setPrecision(ingredients.stream().mapToDouble(o -> o.getPotassium()).sum()));
        sumIngredients.setTotalCarbohydrates(setPrecision(ingredients.stream().mapToDouble(o -> o.getTotalCarbohydrates()).sum()));
        sumIngredients.setProtein(setPrecision(ingredients.stream().mapToDouble(o -> o.getProtein()).sum()));
        return sumIngredients;
    }

    private double setPrecision(double value) {
        return BigDecimal.valueOf(value)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    public boolean deleteIngredientById(Long id) {
        return nutritionRepo.deleteById(id);
    }

    public void deleteAllIngredient() {
        nutritionRepo.deleteAll();
    }
}
