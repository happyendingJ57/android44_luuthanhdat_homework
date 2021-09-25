package function_home;

import java.util.List;

import function_home.Food;

public class Category {

    private  String nameCatery;
    private List<Food> foods;

    public Category(String nameCatery, List<Food> foods) {
        this.nameCatery = nameCatery;
        this.foods = foods;
    }

    public String getNameCatery() {
        return nameCatery;
    }

    public void setNameCatery(String nameCatery) {
        this.nameCatery = nameCatery;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}
