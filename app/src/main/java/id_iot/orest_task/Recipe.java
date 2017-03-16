package id_iot.orest_task;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String recipeName;
    private String recipeDetail;
    private int recipePhoto;
    private ArrayList<Recipe> recipies = new ArrayList<>();

    public Recipe(){
        recipies.add(new Recipe("Birds milk", "milk, bird, food", R.drawable.birdsmilk));
        recipies.add(new Recipe("Honey cake", "honey, sugar, milk", R.drawable.cake));
        recipies.add(new Recipe("Cookie", "mint", R.drawable.pyrig));
        recipies.add(new Recipe("Sweets", "berries", R.drawable.bisquits));
        recipies.add(new Recipe("Cookies", "marchmello,chocolade", R.drawable.marchmello));
        recipies.add(new Recipe("Something tasty", "sugar,fat", R.drawable.tasty));
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


    public List<Recipe> findRecipe(Recipe recipeName) {
        List<Recipe> result = new ArrayList<>();

        for (Recipe i : recipies) {
            if  (i.getRecipeName().equals(recipeName))
                result.add(i);
        }

        if (result.size() != 0)
            showRecipe(result);
        else
            System.out.println("Found nothing");
        return result;
    }

    private void showRecipe(List<Recipe> input) {
        for (Recipe i : input)
            System.out.println(i.getRecipeName() + " " + i.getRecipeDetail() + " " );
    }
}
