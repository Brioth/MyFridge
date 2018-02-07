package be.pxl.ccelen.myfridge_cocktails.data;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.Observable;
import android.databinding.PropertyChangeRegistry;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import be.pxl.ccelen.myfridge_cocktails.BR;

/**
 * Created by Ik on 27/01/2018.
 */

public class Cocktail{

    @SerializedName("idDrink")
    private String id;

    @SerializedName("strDrink")
    private String name;

    private String strCategory;
    private String strAlcoholic;
    private String strGlass;
    private String strInstructions;

    @SerializedName("strDrinkThumb")
    private String thumbUrl;

    private String strIngredient1;
    private String strIngredient2;
    private String strIngredient3;
    private String strMeasure1;
    private String strMeasure2;
    private String strMeasure3;

    public Cocktail(String id, String name){
        this.id = id;
        this.name = name;
    }


    public Cocktail(String id, String name, String strCategory, String strAlcoholic, String strGlass, String strInstructions, String thumbUrl, String strIngredient1, String strIngredient2, String strIngredient3, String strMeasure1, String strMeasure2, String strMeasure3) {
        this(id, name);

        this.strCategory = strCategory;
        this.strAlcoholic = strAlcoholic;
        this.strGlass = strGlass;
        this.strInstructions = strInstructions;
        this.thumbUrl = thumbUrl;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strMeasure1 = strMeasure1;
        this.strMeasure2 = strMeasure2;
        this.strMeasure3 = strMeasure3;

    }

    public String getId() {
        return id;
    }

    public void setId(String id){this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name){this.name = name;}


    public String getStrCategory() {
        return strCategory;
    }

    public String getStrAlcoholic() {
        return strAlcoholic;
    }

    public String getStrGlass() {
        return strGlass;
    }

    public String getStrInstructions() {
        return strInstructions;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getStrIngredient1() {
        return strIngredient1;
    }

    public String getStrIngredient2() {
        return strIngredient2;
    }

    public String getStrIngredient3() {
        return strIngredient3;
    }

    public String getStrMeasure1() {
        return strMeasure1;
    }

    public String getStrMeasure2() {
        return strMeasure2;
    }

    public String getStrMeasure3() {
        return strMeasure3;
    }

    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }

    public void setStrAlcoholic(String strAlcoholic) {
        this.strAlcoholic = strAlcoholic;
    }

    public void setStrGlass(String strGlass) {
        this.strGlass = strGlass;
    }

    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public void setStrIngredient1(String strIngredient1) {
        this.strIngredient1 = strIngredient1;
    }

    public void setStrIngredient2(String strIngredient2) {
        this.strIngredient2 = strIngredient2;
    }

    public void setStrIngredient3(String strIngredient3) {
        this.strIngredient3 = strIngredient3;
    }

    public void setStrMeasure1(String strMeasure1) {
        this.strMeasure1 = strMeasure1;
    }

    public void setStrMeasure2(String strMeasure2) {
        this.strMeasure2 = strMeasure2;
    }

    public void setStrMeasure3(String strMeasure3) {
        this.strMeasure3 = strMeasure3;
    }
}
