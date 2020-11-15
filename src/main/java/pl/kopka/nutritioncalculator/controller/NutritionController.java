package pl.kopka.nutritioncalculator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.kopka.nutritioncalculator.model.SumIngredients;
import pl.kopka.nutritioncalculator.service.NutritionService;
import pl.kopka.nutritioncalculator.model.Ingredient;
import pl.kopka.nutritioncalculator.model.NewIngredient;

import java.util.List;


@Controller
@CrossOrigin
@RequestMapping("/api/nutrition")
public class NutritionController {

    private NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @PostMapping
    public ResponseEntity<?> getIngredientInfo(@RequestBody NewIngredient newIngredient) throws JsonProcessingException {
        ResponseEntity<?> responseEntity = nutritionService.getIngredientsInfo(newIngredient);
        List<Ingredient> ingredients = nutritionService.getAllIngredients();
        if(responseEntity.getStatusCode().is2xxSuccessful()){
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        }
        return responseEntity;
    }

    @GetMapping
    public ResponseEntity<List<Ingredient>> getAllIngredients() {
        return new ResponseEntity<>(nutritionService.getAllIngredients(), HttpStatus.OK);
    }

    @GetMapping("/summary")
    public ResponseEntity<SumIngredients> getSummaryOfIngredients() {
        return new ResponseEntity<>(nutritionService.getSummaryOfIngredients(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIngredientById(@PathVariable Long id) {
        if (nutritionService.deleteIngredientById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/reset")
    public ResponseEntity<?> deleteAllIngredient() {
        nutritionService.deleteAllIngredient();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
