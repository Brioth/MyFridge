package be.pxl.ccelen.myfridge_cocktails;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

/**
 * Created by ccele on 8/02/2018.
 */
class CocktailViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView nameTextView;
    NetworkImageView imageView;

    public CocktailViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        nameTextView = (TextView) itemView.findViewById(R.id.tv_cocktailName);
        imageView = (NetworkImageView) itemView.findViewById(R.id.iv_cocktailThumb);
    }

    @Override
    public void onClick(View view) {

    }
}
