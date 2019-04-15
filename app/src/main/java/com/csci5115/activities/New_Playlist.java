package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class New_Playlist extends AppCompatActivity {

    private Button mBtLaunchPopList;
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

        mBtBacktoHost = (Button) findViewById(R.id.Back);

        mBtBacktoHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    private void LaunchPop(String name) {
        Intent intent = new Intent(this, Pop_PlayListActivity.class);
        intent.putExtra("playListName", name);
        startActivity(intent);
    }


}
