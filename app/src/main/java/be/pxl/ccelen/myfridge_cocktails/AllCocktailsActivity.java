package be.pxl.ccelen.myfridge_cocktails;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import be.pxl.ccelen.myfridge_cocktails.data.Cocktail;
import be.pxl.ccelen.myfridge_cocktails.data.DrinksResult;
import be.pxl.ccelen.myfridge_cocktails.utilities.MySingleton;

public class AllCocktailsActivity extends AppCompatActivity {
    private String TAG = "AllCocktailsActivityError";

    private List<Cocktail> cocktailList = new ArrayList<>();
    private RecyclerView mCocktailList;
    private CocktailAdapter mAdapter;
    private Cursor mCursor;
    private Gson gson;
    private DrinksResult drinks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_cocktails);

        mCocktailList = (RecyclerView) this.findViewById(R.id.rv_cocktails);
        mCursor = getJSONCursor(drinks);
        mAdapter = new CocktailAdapter(this, mCursor);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        mCocktailList.setLayoutManager(new LinearLayoutManager(this));
        mCocktailList.setAdapter(mAdapter);

        loadCocktails();

    }

    private void loadCocktails(){
        StringRequest request = new StringRequest(Request.Method.GET, getString(R.string.alcoholicUrl), onCocktailLoaded, onCocktailError);
        MySingleton.getInstance(this).addToRequestQueue(request);



    }

    private final Response.Listener<String> onCocktailLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            drinks = gson.fromJson(response, DrinksResult.class);
            cocktailList = drinks.getDrinks();

            mAdapter.notifyDataSetChanged();


        }
    };

    private final Response.ErrorListener onCocktailError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, error.toString());
        }
    };

    private Cursor getJSONCursor(String response){
        try{
            JSONArray array = new JSONArray(response);
            return new JSONArrayCursor(array);
        } catch (JSONException exception){
            String ex = exception.getMessage();
        }
        return null;
    }
}
