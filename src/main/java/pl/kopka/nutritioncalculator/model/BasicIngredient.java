package pl.kopka.nutritioncalculator.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class BasicIngredient {
    private double calories;
    private double weight;
    private double totalFat;
    private double cholesterol;
    private double sodium;
    private double potassium;
    private double totalCarbohydrates;
    private double protein;
}
