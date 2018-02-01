//package be.pxl.ccelen.myfridge_cocktails;
//
//import android.content.Context;
//import android.database.Cursor;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
///**
// * Created by Ik on 31/01/2018.
// */
//
//public class CocktailListAdapter extends RecyclerView.Adapter<CocktailListAdapter.CocktailListViewHolder> {
//
//    private Cursor mCursor;
//    private Context mContext;
//
//    public CocktailListAdapter(Context context, Cursor cursor){
//        this.mContext = context;
//        this.mCursor = cursor;
//    }
//
//    @Override
//    public CocktailListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(mContext);
//        View view = inflater.inflate(R.layout.cocktails_list_item, parent, false);
//        return new CocktailListViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(CocktailListViewHolder holder, int position) {
//        if(!mCursor.moveToPosition(position)){
//            return;
//        }
//
//        String cocktailName = cocktailList.get(position);
//        holder.nameTextView.setText(cocktailName);
//    }
//
//    @Override
//    public int getItemCount() {
//        if(mCursor==null){
//            return 0;
//        }
//
//        return mCursor.getCount();
//    }
//
//    public void swapCursor(Cursor newCursor){
//        if(mCursor != null) mCursor.close();
//
//        mCursor = newCursor;
//        if(newCursor!=null){
//            this.notifyDataSetChanged();
//        }
//    }
//
//    class CocktailListViewHolder extends RecyclerView.ViewHolder {
//        TextView pos1TextView;
//        TextView nameTextView;
//
//        public CocktailListViewHolder(View itemView){
//            super(itemView);
//            pos1TextView = (TextView) itemView.findViewById(R.id.)
//        }
//    }
//}
