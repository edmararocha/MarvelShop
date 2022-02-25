package com.example.marvelshop;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ShirtsAdapter extends RecyclerView.Adapter<ShirtsAdapter.ViewHolder> {

    private ArrayList<Shirt> mShirtsData;
    private Context mContext;
    private ImageView mShirtsImage;

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

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mTitleView;
        private TextView mInfoView;
        private TextView mPriceView;
        private ImageView mImageView;


        public ViewHolder(View itemView) {
            super(itemView);

            mTitleView = itemView.findViewById(R.id.title);
            mInfoView = itemView.findViewById(R.id.description);
            mPriceView = itemView.findViewById(R.id.price);
            mImageView = itemView.findViewById(R.id.shirtsImage);
        }
    }
}
