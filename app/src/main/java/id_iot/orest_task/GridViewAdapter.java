package id_iot.orest_task;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter implements Filterable {
    private ValueFilter valueFilter;
    private Context mContext;
    private ArrayList<Recipe> recipes;
    private ArrayList<Recipe> backupRecipes;

    public GridViewAdapter(Context context, ArrayList<Recipe> recipes) {
        this.mContext = context;
        this.recipes = recipes;
        this.backupRecipes = recipes;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return recipes.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        convertView = layoutInflater.inflate(R.layout.grid_view_cell, null);

        ImageView recipePhoto = (ImageView) convertView.findViewById(R.id.grid_image);
        TextView recipeName = (TextView) convertView.findViewById(R.id.grid_name);
        recipeName.setText(recipes.get(position).getRecipeName());
        recipePhoto.setImageResource(recipes.get(position).getRecipePhoto());
        return convertView;
    }




    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (!constraint.toString().isEmpty()){
                List<Recipe> search = searchRecipeName(constraint, recipes);
                results.count = search.size();
                results.values = search;
            } else {
                results.count = backupRecipes.size();
                results.values = backupRecipes;
            }
            return results;
        }

        private List<Recipe> searchRecipeName(CharSequence name, ArrayList<Recipe> recipes){
            List<Recipe> filterList = new ArrayList<>();
            for (Recipe recipe: recipes) {
                if (checkNames(name.toString(), recipe.getRecipeName())){
                    filterList.add(recipe);
                }
            }
            return filterList;
        }

        private boolean checkNames(String toFindName, String recipeName){
            return recipeName.toUpperCase().contains(toFindName.toUpperCase());
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            recipes = (ArrayList) results.values;
            notifyDataSetChanged();
        }
    }

    public ArrayList<Recipe> getRecipes(){
        return this.recipes;
    }
}
