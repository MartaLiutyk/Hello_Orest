package id_iot.orest_task;

import android.content.Context;
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
    private GridView collectionView;
    private ArrayList<Recipe> recipes;
    private SearchView findRecipe;
    private GridViewAdapter gridViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.grid_view_fragment, container, false);
       // getActivity().setTitle(R.string.main_menu);

        recipes = ((MainActivity) getActivity()).getRecipesList();

        setUpCollection(view);
        setUpSearching(view);

        return view;
    }

    private void setUpCollection(View view){
        collectionView = (GridView) view.findViewById(R.id.collection_view);
       gridViewAdapter = new GridViewAdapter(getContext(), recipes);
        collectionView.setAdapter(gridViewAdapter);

        collectionView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),  gridViewAdapter.getRecipes().get(i).getRecipeName(), Toast.LENGTH_SHORT).show();
                gridViewAdapter.getRecipes().get(i).changeFavorite();
                gridViewAdapter.notifyDataSetChanged();

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
                gridViewAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}