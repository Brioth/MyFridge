package be.pxl.ccelen.myfridge_cocktails;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class CocktailPagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public CocktailPagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                CocktailFindByNameFragment tab1 = new CocktailFindByNameFragment();
                return tab1;
            case 1:
                CocktailFindByIngredientFragment tab2 = new CocktailFindByIngredientFragment();
                return tab2;
            case 2:
                CocktailFavoritesFragment tab3 = new CocktailFavoritesFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
