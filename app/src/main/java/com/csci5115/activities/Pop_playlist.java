package com.csci5115.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Pop_playlist extends AppCompatActivity {


    List<Product> productList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_playlist);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        productList = new ArrayList<>();



        productList.add(
                new Product(
                        1,
                        "song1",
                        "13.3 inch, Silver, 1.35 kg",
                        4.3,
                        600,
                        R.drawable.macbook));

        productList.add(
                new Product(
                        1,
                        "song2",
                        "14 inch, Gray, 1.659 kg",
                        4.3,
                        600,
                        R.drawable.dellinspiron));

        productList.add(
                new Product(
                        1,
                        "song3",
                        "13.3 inch, Silver, 1.35 kg",
                        4.3,
                        600,
                        R.drawable.surface));


        ProductAdapter adapter = new ProductAdapter(this, productList);


        recyclerView.setAdapter(adapter);
    }

}
