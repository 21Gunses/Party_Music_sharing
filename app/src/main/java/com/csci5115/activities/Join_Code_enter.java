package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Join_Code_enter extends AppCompatActivity {

    private Button mBtGoBack;
    private Button mBtJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join__code_enter);

        mBtGoBack = (Button) findViewById(R.id.Back);

        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        mBtJoin = (Button) findViewById(R.id.Join);

        mBtJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchJoin();

            }
        });

    }

    private void launchJoin() {

        Intent intent = new Intent(this, Pop_playlist.class);
        startActivity(intent);
    }
}
