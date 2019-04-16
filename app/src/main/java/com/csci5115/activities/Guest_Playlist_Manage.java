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

public class Guest_Playlist_Manage extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private Button mBtQuitParty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_playlist_manage);

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
                        "21 Gunses",
                        "13.3 inch, Silver, 1.35 kg",
                        "Green Day",
                        "5:21",
                        R.drawable.album_1));

        productList.add(
                new Product(
                        1,
                        "song2",
                        "14 inch, Gray, 1.659 kg",
                        "test",
                        "test",
                        R.drawable.dellinspiron));

        productList.add(
                new Product(
                        1,
                        "song3",
                        "13.3 inch, Silver, 1.35 kg",
                        "test",
                        "test",
                        R.drawable.surface));

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

        mBtQuitParty = (Button) findViewById(R.id.quit_party);

        mBtQuitParty.setOnClickListener(new View.OnClickListener() {
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