package be.pxl.ccelen.myfridge_cocktails.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.view.View;


import java.util.List;

import be.pxl.ccelen.myfridge_cocktails.BR;

/**
 * Created by Ik on 28/01/2018.
 */

public class DrinksResult extends BaseObservable{
    private ObservableArrayList<Cocktail> drinks;

    public DrinksResult(){
        drinks = new ObservableArrayList<>();
    }

    public void add(Cocktail cocktail){
        drinks.add(cocktail);
    }

    @Bindable
    public ObservableArrayList<Cocktail> getDrinks() {
        return drinks;
    }

    public void setDrinks(ObservableArrayList<Cocktail> drinks){
        this.drinks = drinks;
        notifyPropertyChanged(BR.drinks);
    }
}
