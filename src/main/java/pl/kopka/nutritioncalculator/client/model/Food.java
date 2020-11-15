package pl.kopka.nutritioncalculator.client.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "food_name",
        "brand_name",
        "serving_qty",
        "serving_unit",
        "serving_weight_grams",
        "nf_calories",
        "nf_total_fat",
        "nf_saturated_fat",
        "nf_cholesterol",
        "nf_sodium",
        "nf_total_carbohydrate",
        "nf_dietary_fiber",
        "nf_sugars",
        "nf_protein",
        "nf_potassium",
        "nf_p",
        "photo"
})
@ToString
public class Food {

    @JsonProperty("food_name")
    private String foodName;
    @JsonProperty("brand_name")
    private Object brandName;
    @JsonProperty("serving_qty")
    private Integer servingQty;
    @JsonProperty("serving_unit")
    private String servingUnit;
    @JsonProperty("serving_weight_grams")
    private Integer servingWeightGrams;
    @JsonProperty("nf_calories")
    private Integer nfCalories;
    @JsonProperty("nf_total_fat")
    private Double nfTotalFat;
    @JsonProperty("nf_saturated_fat")
    private Double nfSaturatedFat;
    @JsonProperty("nf_cholesterol")
    private Integer nfCholesterol;
    @JsonProperty("nf_sodium")
    private Integer nfSodium;
    @JsonProperty("nf_total_carbohydrate")
    private Double nfTotalCarbohydrate;
    @JsonProperty("nf_dietary_fiber")
    private Double nfDietaryFiber;
    @JsonProperty("nf_sugars")
    private Double nfSugars;
    @JsonProperty("nf_protein")
    private Double nfProtein;
    @JsonProperty("nf_potassium")
    private Integer nfPotassium;
    @JsonProperty("nf_p")
    private Integer nfP;
    @JsonProperty("photo")
    private Photo photo;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("food_name")
    public String getFoodName() {
        return foodName;
    }

    @JsonProperty("food_name")
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    @JsonProperty("brand_name")
    public Object getBrandName() {
        return brandName;
    }

    @JsonProperty("brand_name")
    public void setBrandName(Object brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("serving_qty")
    public Integer getServingQty() {
        return servingQty;
    }

    @JsonProperty("serving_qty")
    public void setServingQty(Integer servingQty) {
        this.servingQty = servingQty;
    }

    @JsonProperty("serving_unit")
    public String getServingUnit() {
        return servingUnit;
    }

    @JsonProperty("serving_unit")
    public void setServingUnit(String servingUnit) {
        this.servingUnit = servingUnit;
    }

    @JsonProperty("serving_weight_grams")
    public Integer getServingWeightGrams() {
        return servingWeightGrams;
    }

    @JsonProperty("serving_weight_grams")
    public void setServingWeightGrams(Integer servingWeightGrams) {
        this.servingWeightGrams = servingWeightGrams;
    }

    @JsonProperty("nf_calories")
    public Integer getNfCalories() {
        return nfCalories;
    }

    @JsonProperty("nf_calories")
    public void setNfCalories(Integer nfCalories) {
        this.nfCalories = nfCalories;
    }

    @JsonProperty("nf_total_fat")
    public Double getNfTotalFat() {
        return nfTotalFat;
    }

    @JsonProperty("nf_total_fat")
    public void setNfTotalFat(Double nfTotalFat) {
        this.nfTotalFat = nfTotalFat;
    }

    @JsonProperty("nf_saturated_fat")
    public Double getNfSaturatedFat() {
        return nfSaturatedFat;
    }

    @JsonProperty("nf_saturated_fat")
    public void setNfSaturatedFat(Double nfSaturatedFat) {
        this.nfSaturatedFat = nfSaturatedFat;
    }

    @JsonProperty("nf_cholesterol")
    public Integer getNfCholesterol() {
        return nfCholesterol;
    }

    @JsonProperty("nf_cholesterol")
    public void setNfCholesterol(Integer nfCholesterol) {
        this.nfCholesterol = nfCholesterol;
    }

    @JsonProperty("nf_sodium")
    public Integer getNfSodium() {
        return nfSodium;
    }

    @JsonProperty("nf_sodium")
    public void setNfSodium(Integer nfSodium) {
        this.nfSodium = nfSodium;
    }

    @JsonProperty("nf_total_carbohydrate")
    public Double getNfTotalCarbohydrate() {
        return nfTotalCarbohydrate;
    }

    @JsonProperty("nf_total_carbohydrate")
    public void setNfTotalCarbohydrate(Double nfTotalCarbohydrate) {
        this.nfTotalCarbohydrate = nfTotalCarbohydrate;
    }

    @JsonProperty("nf_dietary_fiber")
    public Double getNfDietaryFiber() {
        return nfDietaryFiber;
    }

    @JsonProperty("nf_dietary_fiber")
    public void setNfDietaryFiber(Double nfDietaryFiber) {
        this.nfDietaryFiber = nfDietaryFiber;
    }

    @JsonProperty("nf_sugars")
    public Double getNfSugars() {
        return nfSugars;
    }

    @JsonProperty("nf_sugars")
    public void setNfSugars(Double nfSugars) {
        this.nfSugars = nfSugars;
    }

    @JsonProperty("nf_protein")
    public Double getNfProtein() {
        return nfProtein;
    }

    @JsonProperty("nf_protein")
    public void setNfProtein(Double nfProtein) {
        this.nfProtein = nfProtein;
    }

    @JsonProperty("nf_potassium")
    public Integer getNfPotassium() {
        return nfPotassium;
    }

    @JsonProperty("nf_potassium")
    public void setNfPotassium(Integer nfPotassium) {
        this.nfPotassium = nfPotassium;
    }

    @JsonProperty("nf_p")
    public Integer getNfP() {
        return nfP;
    }

    @JsonProperty("nf_p")
    public void setNfP(Integer nfP) {
        this.nfP = nfP;
    }

    @JsonProperty("photo")
    public Photo getPhoto() {
        return photo;
    }

    @JsonProperty("photo")
    public void setPhoto(Photo photo) {
        this.photo = photo;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
