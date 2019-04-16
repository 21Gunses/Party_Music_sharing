package com.csci5115.activities;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import com.csci5115.activities.dummy.Song;


public class Search_Result extends AppCompatActivity {

    private ImageButton add_button;
    private String origin;
    private String originListName;
    private boolean isAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(Search_Enter.EXTRA_MESSAGE);
        origin = intent.getStringExtra("sendFrom");
        originListName = intent.getStringExtra("listName");

        // Capture the layout's TextView and set the string as its text
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(message);

        final Song song = new Song("6", message, "Alan Walker", "3:00");

        isAdd = false;
        add_button = findViewById(R.id.addButton);
        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addSong(song);
            }
        });
    }

    public void addSong(Song song){
        if (!isAdd){
            add_button.setImageResource(android.R.color.holo_orange_dark);
            isAdd = true;
        }
        else if (origin.equals("newList")){
            Intent intent = new Intent(this, Pop_PlayListActivity.class);
            intent.putExtra("playListName", originListName);
            intent.putExtra("isNew", true);
            intent.putExtra("isAdd", true);
            song.id = "1";
            Bundle bundle = new Bundle();
            bundle.putParcelable("song", song);
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        }
        else if (origin.equals("editList")){
            Intent intent = new Intent(this, PlayListActivity.class);
            intent.putExtra("playListName", originListName);
            intent.putExtra("isAdd", true);
            Bundle bundle = new Bundle();
            bundle.putParcelable("song", song);
            intent.putExtras(bundle);

            startActivity(intent);
            finish();
        }
        else if (origin.equals("request")){

        }
    }
}
