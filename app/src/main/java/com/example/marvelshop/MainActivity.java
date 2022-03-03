package com.example.marvelshop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Shirt> mShirtsData;
    private ShirtsAdapter mAdapter;
    private Toolbar mToolbar;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);

        mButton = findViewById(R.id.buy_button);

        mRecyclerView = findViewById(R.id.recyclerView);

        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        mShirtsData = new ArrayList<>();

        mAdapter = new ShirtsAdapter(this, mShirtsData);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
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