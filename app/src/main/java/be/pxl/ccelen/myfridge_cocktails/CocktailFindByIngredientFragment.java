package be.pxl.ccelen.myfridge_cocktails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import be.pxl.ccelen.myfridge_cocktails.data.Cocktail;
import be.pxl.ccelen.myfridge_cocktails.utilities.MySingleton;

public class CocktailFindByIngredientFragment extends Fragment implements Spinner.OnItemSelectedListener{

    private static final String filteredBaseUrl = "http://www.thecocktaildb.com/api/json/v1/1/filter.php?i=";
    private static final String TAG = CocktailFindByIngredientFragment.class.getName();

    private Spinner spinner;
    private ArrayList<String> ingredients;
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private CocktailAdapter adapter;

    public CocktailFindByIngredientFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cocktail_findby_ingredient, container, false);

        ingredients = new ArrayList<String>();

        spinner = (Spinner) rootView.findViewById(R.id.sp_ingredients);
        spinner.setOnItemSelectedListener(this);

        fillIngredients();

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_findByIngredient);
        //recyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        return rootView;
    }

    private void fillIngredients(){

        StringRequest request = new StringRequest(Request.Method.GET, getString(R.string.ingredientsUrl), onIngredientsLoaded, onIngredientsError);
        MySingleton.getInstance(getContext()).addToRequestQueue(request);

    }

    private final Response.Listener<String> onIngredientsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "onIngredientsLoaded response: " + response);

            try{
                ingredients.clear();
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("drinks");
                for (int i = 0; i<jsonArray.length(); i++){
                    JSONObject ingredient = jsonArray.getJSONObject(i);
                    ingredients.add(ingredient.getString("strIngredient1"));
                    Collections.sort(ingredients, String.CASE_INSENSITIVE_ORDER);
                }

            } catch (JSONException e){
                e.printStackTrace();
            }

            spinner.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, ingredients));

        }
    };

    private final Response.ErrorListener onIngredientsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, error.toString());
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String ingredient = spinner.getSelectedItem().toString();
        Log.d(TAG, "onItemSelected: " + ingredient);
        requestFilteredCocktails(ingredient);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //TODO
    }

    private void requestFilteredCocktails(String ingredient){
        String url = filteredBaseUrl + ingredient;
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onFilteredloaded response: " + response);

                List<Cocktail> cocktails = new ArrayList<Cocktail>();

                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("drinks");
                    for (int i = 0; i<jsonArray.length(); i++) {
                        String json = jsonArray.getString(i);
                        Gson gson = new Gson();
                        Cocktail cocktail = gson.fromJson(json, Cocktail.class);
                        cocktails.add(cocktail);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                adapter = new CocktailAdapter(getContext(), cocktails);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d(TAG, "Error "+ volleyError.getMessage());
            }
        });
        MySingleton.getInstance(getContext()).addToRequestQueue(request);
    }
}
