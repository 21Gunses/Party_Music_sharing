package com.csci5115.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Search_Enter extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.search.MESSAGE";
    private String origin;
    private String originListName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_enter);
        Intent intent = getIntent();
        origin = intent.getStringExtra("sendFrom");
        originListName = intent.getStringExtra("listName");
    }

    /* Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, Search_Result.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra("sendFrom", origin);
        intent.putExtra("listName", originListName);
        startActivity(intent);
        finish();
    }
}
