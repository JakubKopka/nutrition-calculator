package pl.kopka.nutritioncalculator.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Ingredient extends BasicIngredient {
    private Long id;
    private String imgUrl;
    private String food;
    private String unit;
}
