package be.pxl.ccelen.myfridge_cocktails;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import be.pxl.ccelen.myfridge_cocktails.data.Cocktail;
import be.pxl.ccelen.myfridge_cocktails.data.DrinksResult;
import be.pxl.ccelen.myfridge_cocktails.utilities.MySingleton;

public class RandomCocktailActivity extends BaseActivity {

    private static final String TAG = "RandomCocktailActivity";
    private TextView cocktailName;
    private ImageButton cocktailThumb;
    private Gson gson;
    private DrinksResult drinks;
    private Cocktail cocktail;
    NetworkImageView imageView;
    String url;
    ProgressDialog PD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_cocktail);

        cocktailName = (TextView) findViewById(R.id.tv_cocktailName);
        imageView = (NetworkImageView) findViewById(R.id.iv_cocktailThumb);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gsonBuilder.create();

        getRandomCocktail();

        final Button button = findViewById(R.id.bt_newRandom);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                getRandomCocktail();
            }
        });

    }

    private void getRandomCocktail(){
        StringRequest request = new StringRequest(Request.Method.GET, getString(R.string.randomUrl), onCocktailLoaded, onCocktailError);
        MySingleton.getInstance(this).addToRequestQueue(request);

    }

    private final Response.Listener<String> onCocktailLoaded = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            drinks = gson.fromJson(response, DrinksResult.class);
            cocktail = drinks.getDrinks().get(0);
            String thumbUrl = "http://" + cocktail.getThumbUrl();

            cocktailName.setText(cocktail.getName());
            ImageLoader imageLoader = MySingleton.getInstance(getApplicationContext()).getImageLoader();
            imageView.setImageUrl(thumbUrl, imageLoader);

        }
    };

    private final Response.ErrorListener onCocktailError = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.e(TAG, error.toString());
        }
    };


}
