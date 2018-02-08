package be.pxl.ccelen.myfridge_cocktails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import be.pxl.ccelen.myfridge_cocktails.data.DrinksResult;
import be.pxl.ccelen.myfridge_cocktails.utilities.MySingleton;

/**
 * A placeholder fragment containing a simple view.
 */
public class CocktailFindByIngredientFragment extends Fragment implements Spinner.OnItemSelectedListener{
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String TAG = "IngredientsFragment";

    private Spinner spinner;
    private ArrayList<String> ingredients;
    private JSONArray result;

    public CocktailFindByIngredientFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static CocktailFindByIngredientFragment newInstance(int sectionNumber) {
        CocktailFindByIngredientFragment fragment = new CocktailFindByIngredientFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_cocktail_findby_ingredient, container, false);

        ingredients = new ArrayList<String>();

        spinner = (Spinner) rootView.findViewById(R.id.sp_ingredients);
        spinner.setOnItemSelectedListener(this);

        fillIngredients();

        return rootView;
    }

    private void fillIngredients(){

        StringRequest request = new StringRequest(Request.Method.GET, getString(R.string.ingredientsUrl), onIngredientsLoaded, onIngredientsError);
        MySingleton.getInstance(getContext()).addToRequestQueue(request);

    }

    private final Response.Listener<String> onIngredientsLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(TAG, "onResponse: " + response);

            JSONObject j = null;
            try{
                j = new JSONObject(response);
                result = j.getJSONArray("drinks");
                getIngredients(result);
            } catch (JSONException e){
                e.printStackTrace();
            }
        }
    };

    private final Response.ErrorListener onIngredientsError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, error.toString());
        }
    };

    private void getIngredients(JSONArray j){
        for (int i=0; i<j.length(); i++){
            try{
                JSONObject json = j.getJSONObject(i);
                ingredients.add(json.getString("strIngredient1"));
            } catch (JSONException e){
                e.printStackTrace();
            }
        }

        spinner.setAdapter(new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item, ingredients));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //TODO
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        //TODO
    }
}
