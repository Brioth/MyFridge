package be.pxl.ccelen.myfridge_cocktails.data;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ik on 28/01/2018.
 */

public class DrinksResult{
    private List<Cocktail> drinks;

    public DrinksResult()
    {
        drinks = new ArrayList<>();
    }

    public void add(Cocktail cocktail){
        drinks.add(cocktail);
    }


    public List<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Cocktail> drinks){
        this.drinks = drinks;
    }
}
