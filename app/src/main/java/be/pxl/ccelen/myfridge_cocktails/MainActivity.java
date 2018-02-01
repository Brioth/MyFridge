package be.pxl.ccelen.myfridge_cocktails;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;

        switch (item.getItemId()){
            case R.id.action_home:
                intent = new Intent(this, MainActivity.class);
                break;
            case R.id.action_random:
                intent = new Intent(this, RandomCocktailActivity.class);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        this.startActivity(intent);
        return true;
    }
}
