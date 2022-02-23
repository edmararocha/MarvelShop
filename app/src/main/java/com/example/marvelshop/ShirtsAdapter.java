package com.example.marvelshop;

import android.content.Context;
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
        Shirt currentShirt = mShirtsData.get(position);
        holder.bindTo(currentShirt);
    }

    @Override
    public int getItemCount() {
        return mShirtsData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleView;
        private TextView mInfoView;


        public ViewHolder(View itemView) {
            super(itemView);

            mTitleView = itemView.findViewById(R.id.title);
            mInfoView = itemView.findViewById(R.id.description);
            mShirtsImage = itemView.findViewById(R.id.shirtsImage);

//            itemView.setOnClickListener(this);
        }

        public void bindTo(Shirt currentShirt) {
            mTitleView.setText(currentShirt.getTitle());
            mInfoView.setText(currentShirt.getInfo());

            Glide.with(mContext).load(currentShirt.getImageResource()).into(mShirtsImage);

        }

        @Override
        public void onClick(View view) {
            Shirt currentShirt = mShirtsData.get(getAdapterPosition());
        }
    }
}
