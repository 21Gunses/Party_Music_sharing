package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Summary extends AppCompatActivity {

    private Button mBtBackhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        mBtBackhome = (Button) findViewById(R.id.button_backhome);

        mBtBackhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                launchHome();

            }
        });
    }

    private void launchHome() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}
