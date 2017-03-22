package id_iot.orest_task;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridViewFragment extends Fragment {
    private ArrayList<Recipe> recipes;
    GridView gridView;
    FloatingActionButton changeToCard;
    private GridViewAdapter gridViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.grid_view, container, false);
        getActivity().setTitle("Menu");

        gridView = (GridView) view.findViewById(R.id.gridview);
        recipes = ((MainActivity) getActivity()).getRecipesList();
        final GridViewAdapter gridViewAdapter = new GridViewAdapter(getContext(), recipes);
        gridView.setAdapter( gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),  gridViewAdapter.getRecipes().get(i).getRecipeName(), Toast.LENGTH_SHORT).show();
            }
        });

        SearchView recipeSearchView = (SearchView) view.findViewById(R.id.searchRecipe);
        CharSequence query = recipeSearchView.getQuery();
        recipeSearchView.setIconifiedByDefault(false);

        recipeSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                gridViewAdapter.getFilter().filter(newText);
                return false;
            }
        });


        changeToCard = (FloatingActionButton) view.findViewById(R.id.changeToCard);
        changeToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new RecyclerViewFragment());
            }
        });
        return view;
    }
}
