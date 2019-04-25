package com.csci5115.activities;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button mBtLaunchHost;
    private Button mBtLaunchJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtLaunchHost = (Button) findViewById(R.id.bt_Host);

        mBtLaunchHost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchHost();
            }
        });

        mBtLaunchJoin = (Button) findViewById(R.id.bt_Join);

        mBtLaunchJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchJoin();

            }
        });
    }

    private void launchHost() {

        Intent intent = new Intent(this, Host_Code_Display.class);
        startActivity(intent);
    }

    private void launchJoin() {

        Intent intent = new Intent( this, Join_Code_enter.class);
        startActivity(intent);
    }
}
