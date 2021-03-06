package food.hello_orest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by melod on 26.03.2017.
 */
public class RecipesBookFragment extends Fragment {
    private GridView collectionView;
    private ArrayList<Recipe> recipes;
    private SearchView findRecipe;
    private RecipesBookAdapter recipesBookAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recipes_book_fragment, container, false);

        recipes = ((MainActivity) getActivity()).getRecipesList();

        setUpCollection(view);
        setUpSearching(view);

        return view;
    }

    private void setUpCollection(View view){
        collectionView = (GridView) view.findViewById(R.id.collection_view);
        recipesBookAdapter = new RecipesBookAdapter(getContext(), recipes);
        collectionView.setAdapter(recipesBookAdapter);

        collectionView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),  recipesBookAdapter.getRecipes().get(i).getRecipeName(), Toast.LENGTH_SHORT).show();
                recipesBookAdapter.getRecipes().get(i).changeFavorite();
                recipesBookAdapter.notifyDataSetChanged();

            }
        });
    }

    private void setUpSearching(View view){
        findRecipe = (SearchView) view.findViewById(R.id.searchRecipe);
        findRecipe.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                recipesBookAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

}
