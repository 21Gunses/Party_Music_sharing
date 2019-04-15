package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class New_Playlist extends AppCompatActivity {

    private Button mBtLaunchPopList;
    private Button mBtLaunchDanceList;
    private Button mBtLaunchRockList;
    private Button mBtLaunchHipList;
    private Button mBtStartEmptyList;
    private Button mBtBacktoHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_playlist);

        mBtLaunchPopList = (Button) findViewById(R.id.Pop);
        mBtLaunchPopList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaunchPop("POP");
            }
        });

        mBtLaunchDanceList = (Button) findViewById(R.id.Dance);
        mBtLaunchDanceList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaunchPop("Dance");
            }
        });

        mBtLaunchRockList = (Button) findViewById(R.id.Rock);
        mBtLaunchRockList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaunchPop("Rock");
            }
        });

        mBtLaunchHipList = (Button) findViewById(R.id.Hiphop);
        mBtLaunchHipList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LaunchPop("Hip-Hop");
            }
        });

        mBtBacktoHost = (Button) findViewById(R.id.Back);
        mBtBacktoHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        mBtStartEmptyList = (Button) findViewById(R.id.Empty);
        mBtStartEmptyList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CreateEmpty("Default List", true);
            }
        });
    }

    private void LaunchPop(String name) {
        Intent intent = new Intent(this, Pop_PlayListActivity.class);
        intent.putExtra("playListName", name);
        startActivity(intent);
    }

    private void CreateEmpty(String name, boolean isNew) {
        Intent intent = new Intent(this, Pop_PlayListActivity.class);
        intent.putExtra("playListName", name);
        intent.putExtra("isNew", isNew);
        startActivity(intent);
    }


}
