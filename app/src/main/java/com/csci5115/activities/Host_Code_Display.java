package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Host_Code_Display extends AppCompatActivity {

    private Button mBtGoBack;

    private Button mBtNewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_host_code_display);

        mBtGoBack = (Button) findViewById(R.id.Back);

        mBtGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });

        mBtNewList = (Button) findViewById(R.id.buttonLetsGo);

        mBtNewList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchListRecommendation();

            }
        });
    }

    private void launchListRecommendation() {

        Intent intent = new Intent(Host_Code_Display.this, PlayListActivity.class);
        startActivity(intent);
        //Host_Code_Display.this.finish();
    }
}
