package com.csci5115.activities;

/**
 * Created by karanjaswani on 1/12/18.
 */
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<Product> productList;

    public ImageButton mBtSongUpvote;
    public ImageButton mBtSongDownvote;

    //getting the context and product list with constructor
    public ProductAdapter(Context mCtx, List<Product> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_products, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        Product product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getTitle());
        //holder.textViewShortDesc.setText(product.getShortdesc());
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewVotes.setText(String.valueOf(""+product.getVotes()));
        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }


    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewRating, textViewPrice, textViewVotes;
        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.song_name);
            //textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.song_artist);
            textViewPrice = itemView.findViewById(R.id.song_time);
            textViewVotes = itemView.findViewById(R.id.song_votes);
            imageView = itemView.findViewById(R.id.imageView);
            mBtSongUpvote = (ImageButton) itemView.findViewById(R.id.upvote);
            mBtSongDownvote = (ImageButton) itemView.findViewById(R.id.downvote);
            mBtSongUpvote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    upvoteAt(getPosition());
                }
            });
            mBtSongDownvote.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    downvoteAt(getPosition());
                }
            });
        }
    }

    public void upvoteAt(int position) {

//        mValues.remove(position);
//        notifyItemRemoved(position);
        if (position-1 >= 0) {
            notifyItemMoved(position, position-1);
        }
//        notifyItemRangeChanged(position, mValues.size());
    }

    public void downvoteAt(int position) {

//        mValues.remove(position);
//        notifyItemRemoved(position);
        if (position+1 <= productList.size()-1) {
            notifyItemMoved(position, position+1);
        }
//        notifyItemRangeChanged(position, mValues.size());
    }
}
