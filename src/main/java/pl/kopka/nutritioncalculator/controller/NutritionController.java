package pl.kopka.nutritioncalculator.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.kopka.nutritioncalculator.client.model.ErrorApi;
import pl.kopka.nutritioncalculator.client.model.Foods;
import pl.kopka.nutritioncalculator.model.SumIngredients;
import pl.kopka.nutritioncalculator.service.NutritionService;
import pl.kopka.nutritioncalculator.model.Ingredient;
import pl.kopka.nutritioncalculator.model.NewIngredient;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@Controller
@CrossOrigin
@RequestMapping("/api/nutrition")
public class NutritionController {
    Logger logger = Logger.getLogger(NutritionService.class.getName());


    private NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @PostMapping
    public ResponseEntity<?> getIngredientInfo(@RequestBody NewIngredient newIngredient) throws JsonProcessingException {
        try {
            List<Ingredient> ingredientList = nutritionService.getIngredientsInfo(newIngredient);
            return new ResponseEntity<>(ingredientList, HttpStatus.OK);
        } catch (HttpClientErrorException ex) {
            logger.log(Level.WARNING, ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ObjectMapper().readValue(ex.getResponseBodyAsString(), ErrorApi.class)
            );
        }
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
