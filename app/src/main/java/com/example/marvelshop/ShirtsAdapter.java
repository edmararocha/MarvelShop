package com.example.marvelshop;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShirtsAdapter extends RecyclerView.Adapter<ShirtsAdapter.ViewHolder> {

    private ArrayList<Shirt> mShirtsData;
    private Context mContext;

    ShirtsAdapter( Context context, ArrayList<Shirt> shirtsData) {
        super();
        this.mShirtsData = shirtsData;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ShirtsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.shirt_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ShirtsAdapter.ViewHolder holder, int position) {

        holder.mTitleView.setText(mShirtsData.get(position).getTitle());
        holder.mInfoView.setText(mShirtsData.get(position).getInfo());
        holder.mPriceView.setText(mShirtsData.get(position).getPrice());
        holder.mImageView.setImageResource(mShirtsData.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return mShirtsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleView;
        private TextView mInfoView;
        private TextView mPriceView;
        private ImageView mImageView;


        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            mTitleView = itemView.findViewById(R.id.title);
            mInfoView = itemView.findViewById(R.id.description);
            mPriceView = itemView.findViewById(R.id.price);
            mImageView = itemView.findViewById(R.id.shirtsImage);
        }

        public void onClick(View itemView) {
            Shirt currentShirt = mShirtsData.get(getAdapterPosition());

            Intent detailIntent =new Intent(mContext, DetailShirt.class);

            detailIntent.putExtra("title", currentShirt.getTitle());
            detailIntent.putExtra("info", currentShirt.getInfo());
            detailIntent.putExtra("price", currentShirt.getPrice());
            detailIntent.putExtra("image", currentShirt.getImageResource());

            mContext.startActivity(detailIntent, ActivityOptions.makeSceneTransitionAnimation((Activity) mContext).toBundle());
        }
    }
}
