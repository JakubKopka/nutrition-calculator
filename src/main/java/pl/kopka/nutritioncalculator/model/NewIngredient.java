package pl.kopka.nutritioncalculator.model;


import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class NewIngredient {
    private String name;
    private double weight;
    private String unit = "g";
}
