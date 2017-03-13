package id_iot.orest_task;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipeName;
    private String recipeDetail;
    private int recipePhoto;
    private ArrayList<Recipe> recipies = new ArrayList<>();

    public Recipe(){
        recipies.add(new Recipe("Caesar salad", "chicken,salad,cheese", R.drawable.salad));
        recipies.add(new Recipe("Chicken", "chicken,pepper", R.drawable.chicken));
        recipies.add(new Recipe("Beef", "beef,pepper,salt", R.drawable.beef));
        recipies.add(new Recipe("Sweets", "berries", R.drawable.bisquits));
    }

    private Recipe(String name, String detail, int photo){
        this.recipeName = name;
        this.recipeDetail = detail;
        this.recipePhoto = photo;
    }

    public ArrayList<Recipe> getRecipies(){
        return this.recipies;
    }

    public String getRecipeName(){
        return this.recipeName;
    }

    public String getRecipeDetail(){
        return this.recipeDetail;
    }

    public int getRecipePhoto(){
        return this.recipePhoto;
    }
}
