package be.pxl.ccelen.myfridge_cocktails;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import be.pxl.ccelen.myfridge_cocktails.data.Cocktail;

/**
 * Created by Ik on 31/01/2018.
 */

public class CocktailAdapter extends RecyclerView.Adapter<CocktailAdapter.CocktailViewHolder> {
    private Cursor mCursor;
    private Context mContext;

    //private List<Cocktail> cocktailList;

    public CocktailAdapter(Context context, Cursor cursor)
    {
        //this.cocktailList = cocktailList;
        this.mContext = context;
        this.mCursor = cursor;
    }

    @Override
    public CocktailViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemView = inflater.inflate(R.layout.cocktails_list_item, parent, false);
        return new CocktailViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CocktailViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)){
            return;
        }

        String name = null;
        name = mCursor.getString(mCursor.getColumnIndex("name"));


        //Cocktail cocktail = cocktailList.get(position);
        holder.nameTextView.setText(name);
    }

    @Override
    public int getItemCount() {

        if(mCursor==null){
            return 0;
        }
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if(mCursor!=null) mCursor.close();
        mCursor=newCursor;
        if(newCursor!=null){
            this.notifyDataSetChanged();
        }
    }

    class CocktailViewHolder extends  RecyclerView.ViewHolder {
        TextView nameTextView;

        public CocktailViewHolder(View itemView){
            super(itemView);
            nameTextView = (TextView) itemView.findViewById(R.id.tv_cocktailName);
        }
    }
}
