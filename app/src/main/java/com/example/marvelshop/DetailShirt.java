package com.example.marvelshop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailShirt extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_shirt);

        TextView shirtsTitle = findViewById(R.id.title);
        TextView shirtsInfo = findViewById(R.id.description);
        TextView shirtsPrice = findViewById(R.id.price);
        ImageView shirtsImage = findViewById(R.id.shirtsImage);

        shirtsTitle.setText(getIntent().getStringExtra("title"));
        shirtsInfo.setText(getIntent().getStringExtra("info"));
        shirtsPrice.setText(getIntent().getStringExtra("price"));

        Glide.with(this).load(getIntent().getIntExtra("image", 0)).into(shirtsImage);

        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        if (spinner != null) {
            spinner.setAdapter(adapter);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { }
}