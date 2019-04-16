package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.csci5115.activities.dummy.Song;

import java.util.ArrayList;
import java.util.List;

public class Guest_Playlist_Manage extends AppCompatActivity {

    //a list to store all the products
    List<Product> productList;

    //the recyclerview
    RecyclerView recyclerView;

    private Button mBtQuitParty;
    private Button mBtRequest;

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
                        9,
                        R.drawable.album_2));

        productList.add(
                new Product(
                        1,
                        "Sweet Dreams",
                        "13.3 inch, Silver, 1.35 kg",
                        "Marilyn Manson",
                        "4:53",
                        8,
                        R.drawable.album_3));

        Intent intent = getIntent();
        if (intent.getBooleanExtra("isAdd", false)) {
            Bundle received_bundle = intent.getExtras();
            Song received_song = (Song) received_bundle.getParcelable("song");
            productList.add(
                    new Product(
                            6,
                            received_song.name,
                            "13.3 inch, Silver, 1.35 kg",
                            received_song.artist,
                            received_song.length,
                            0,
                            R.drawable.album_faded));
        }

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

        mBtRequest = (Button) findViewById(R.id.request_song);

        mBtRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                launchSearch();

            }
        });
    }

    private void launchEndParty() {

        Intent intent = new Intent(this, Summary.class);

        //intent.putExtra("listName", listName);
        startActivity(intent);
        finish();
    }

    private void launchSearch() {

        Intent intent = new Intent(this, Search_Enter.class);
        intent.putExtra("sendFrom", "request");
        startActivity(intent);
    }
}