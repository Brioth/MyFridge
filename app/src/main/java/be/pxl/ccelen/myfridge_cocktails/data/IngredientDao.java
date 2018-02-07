package be.pxl.ccelen.myfridge_cocktails.data;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ccele on 2/7/2018.
 */

public interface IngredientDao {
    @Query("SELECT * FROM ingredient")
    List<Ingredient> getAll();

    @Query("SELECT * FROM ingredient WHERE id IN(:ingredientIds)")
    List<Ingredient> loadAllByIds(int[] ingredientIds);

    @Query("SELECT * FROM ingredient WHERE name LIKE :name LIMIT 1")
    Ingredient findByName(String name);

    @Query("SELECT * FROM ingredient WHERE inStock")
    List<Ingredient> getInStock();

    @Insert
    void insertAll(Ingredient... ingredients);

    @Delete
    void delete(Ingredient ingredient);
}
