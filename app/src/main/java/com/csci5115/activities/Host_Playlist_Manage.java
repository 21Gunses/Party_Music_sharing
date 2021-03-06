package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class Host_Playlist_Manage extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private Button mBtEndParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_playlist_manage);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the productlist
        productList = new ArrayList<>();


        //adding some items to our list
        productList.add(
                new Product(
                        1,
                        "21 Guns",
                        "13.3 inch, Silver, 1.35 kg",
                        "Green Day",
                        "5:21",
                        10,
                        R.drawable.album_1));

        productList.add(
                new Product(
                        1,
                        "Come As You Are",
                        "14 inch, Gray, 1.659 kg",
                        "Nirvana",
                        "3:39",
                        10,
                        R.drawable.album_2));

        productList.add(
                new Product(
                        1,
                        "Sweet Dreams",
                        "13.3 inch, Silver, 1.35 kg",
                        "Marilyn Manson",
                        "4:53",
                        9,
                        R.drawable.album_3));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        mBtEndParty = (Button) findViewById(R.id.end_party);

        mBtEndParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchEndParty();

            }
        });
    }

    private void launchEndParty() {

        Intent intent = new Intent(this, Summary.class);
        startActivity(intent);
    }
}
