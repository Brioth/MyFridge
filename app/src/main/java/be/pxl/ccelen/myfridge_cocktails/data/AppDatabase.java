package be.pxl.ccelen.myfridge_cocktails.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by ccele on 2/7/2018.
 */

@Database(entities = Ingredient.class, version = 1)
public abstract class AppDatabase extends RoomDatabase{
    public abstract IngredientDao ingredientDao();
}
