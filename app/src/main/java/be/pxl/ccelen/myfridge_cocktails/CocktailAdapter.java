package be.pxl.ccelen.myfridge_cocktails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.ImageLoader;

import java.util.List;

import be.pxl.ccelen.myfridge_cocktails.data.Cocktail;
import be.pxl.ccelen.myfridge_cocktails.utilities.MySingleton;

/**
 * Created by Ik on 31/01/2018.
 */

public class CocktailAdapter extends RecyclerView.Adapter<CocktailViewHolder> {

    private Context mContext;
    private List<Cocktail> cocktailList;

    public CocktailAdapter(Context context, List<Cocktail> cocktailList)
    {
        this.cocktailList = cocktailList;
        this.mContext = context;
    }

    @Override
    public CocktailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cocktail_list_item,null);
        CocktailViewHolder cv = new CocktailViewHolder(itemView);
        return cv;
    }

    @Override
    public void onBindViewHolder(CocktailViewHolder holder, int position) {
        holder.nameTextView.setText(cocktailList.get(position).getName());

        String thumbUrl = "http://" + cocktailList.get(position).getThumbUrl();
        ImageLoader imageLoader = MySingleton.getInstance(mContext).getImageLoader();
        holder.imageView.setImageUrl(thumbUrl, imageLoader);

    }

    @Override
    public int getItemCount() {

        return this.cocktailList.size();
    }

}
