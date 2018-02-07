package be.pxl.ccelen.myfridge_cocktails.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;


import java.util.ArrayList;
import java.util.List;

import be.pxl.ccelen.myfridge_cocktails.BR;

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
