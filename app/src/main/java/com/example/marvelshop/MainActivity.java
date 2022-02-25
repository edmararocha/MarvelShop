package com.example.marvelshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Shirt> mShirtsData;
    private ShirtsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        mShirtsData = new ArrayList<>();

        mAdapter = new ShirtsAdapter(this, mShirtsData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        String[] shirtsList = getResources()
                .getStringArray(R.array.shirts_title);
        String[] shirtsInfo = getResources()
                .getStringArray(R.array.shirts_info);
        String[] shirtsPrice = getResources()
                .getStringArray(R.array.shirts_price);
        TypedArray shirtsImageResources = getResources().obtainTypedArray(R.array.shirts_image);

        mShirtsData.clear();

        for(int i=0; i<shirtsList.length; i++){

            int id = shirtsImageResources.getResourceId(i,0);
            mShirtsData.add(new Shirt(shirtsList[i],shirtsInfo[i], shirtsPrice[i], id));
            Log.d("image", ""+id);
        }

        mAdapter.notifyDataSetChanged();
    }
}