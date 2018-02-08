package be.pxl.ccelen.myfridge_cocktails;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ccele on 8/02/2018.
 */

abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        Intent intent;

        switch (item.getItemId()){
            case R.id.action_random:
                intent = new Intent(this, RandomCocktailActivity.class);
                break;
            case R.id.action_cocktails:
                intent = new Intent(this, CocktailActivity.class);
                break;
            case R.id.action_cupboard:
                intent = new Intent(this, RandomCocktailActivity.class);
                //TODO implement cupboard
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        this.startActivity(intent);

        return super.onOptionsItemSelected(item);
    }
}
