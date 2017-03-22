package id_iot.orest_task;

import java.util.ArrayList;


/**
 * Created by melod on 22.03.2017.
 */

public class RecipeList {
    private ArrayList<Recipe> recipes = new ArrayList<>();

    public RecipeList(){
        recipes.add(new Recipe("Birds milk", "milk, bird, food", R.drawable.bisquits));
        recipes.add(new Recipe("Cookie", "mint", R.drawable.pyrig));
        recipes.add(new Recipe("Sweets", "berries", R.drawable.bisquits));
        recipes.add(new Recipe("Cookies", "marchmello,chocolade", R.drawable.bisquits));
        recipes.add(new Recipe("Something tasty", "sugar,fat", R.drawable.pyrig));
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }

}
