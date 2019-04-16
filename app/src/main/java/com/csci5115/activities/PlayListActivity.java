package com.csci5115.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;
import android.widget.Toast;

import com.csci5115.activities.dummy.SongList;
import com.csci5115.activities.dummy.Song;

import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity
    implements SongListFragment.OnListFragmentInteractionListener,
        SongFragment.OnListFragmentInteractionListener,
        BlankFragment.OnClickListener,
        BlankFragment2.OnClickListener{

    private Fragment fragment = null;
    private Fragment fragment_button = null;
    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction tf = fm.beginTransaction();

    private String listName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        //Get the fragment manager for this activity (MainActivity)
        //FragmentTransaction tf = getSupportFragmentManager().beginTransaction();

        //listName = intent.getStringExtra("playListName");
        Intent intent = getIntent();

        ArrayList<SongList> items;
        items = new ArrayList<>();

        ArrayList<Song> song_list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            song_list.add(new Song("" + i,"song" + i, "artist"+i, "4:00"));
        }

        items.add(new SongList("1","list1", "5","20:00",song_list));
        items.add(new SongList("2","list2", "5","20:00", song_list));
        items.add(new SongList("3","list3", "5","20:00", song_list));
        items.add(new SongList("4","list4", "5","20:00",song_list));

        if (intent.getBooleanExtra("isAdd", false)){
            TextView title = findViewById(R.id.title);
            title.setText(intent.getStringExtra("playListName"));

            Bundle received_bundle = intent.getExtras();
            Song received_song = (Song) received_bundle.getParcelable("song");
            song_list.add(received_song);

            fragment = new SongFragment();
            fragment_button = new BlankFragment2();
            Bundle args = new Bundle();
            args.putParcelableArrayList("songs", song_list);
            fragment.setArguments(args);

            tf.add(R.id.main_frag, fragment);
            tf.add(R.id.button_frag, fragment_button);

            tf.commit();
        }
        else {
            listName = "Select Your Play List!";
            TextView title = findViewById(R.id.title);
            title.setText(listName);

            fragment = new SongListFragment();
            fragment_button = new BlankFragment();

            Bundle args = new Bundle();
            args.putParcelableArrayList("items", items);
            fragment.setArguments(args);

            tf.add(R.id.main_frag, fragment);
            tf.add(R.id.button_frag, fragment_button);

            tf.commit();
        /*ft.add(R.id.f_layout,f,"");
        ft.commit();*/

        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof BlankFragment) {
            BlankFragment f = (BlankFragment) fragment;
            f.setOnClickListenerListener(this);
        }
        else if (fragment instanceof BlankFragment2) {
            BlankFragment2 f = (BlankFragment2) fragment;
            f.setOnClickListenerListener2(this);
        }
    }

    public void onSongListSelected( SongList item) {
        Toast.makeText(getApplicationContext(), item.name, Toast.LENGTH_SHORT).show();
        SongFragment fragment2 = new SongFragment();
        BlankFragment2 fragment_button = new BlankFragment2();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        TextView title = findViewById(R.id.title);
        title.setText(item.name);
        listName = item.name;

        Bundle args = new Bundle();
        args.putParcelableArrayList("songs", item.song_list);
        fragment2.setArguments(args);


        ft.replace(R.id.main_frag, fragment2);
        ft.replace(R.id.button_frag, fragment_button);

        ft.commit();
    }

    public void onSongSelected( Song item) {
        Toast.makeText(getApplicationContext(), item.name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClicked(int id){
        if (id == 2) {
            //Toast.makeText(getApplicationContext(), ""+id, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, New_Playlist.class);
            startActivity(intent);

        }
        if (id == 3) {
            Intent intent = new Intent(this, Search_Enter.class);
            intent.putExtra("sendFrom", "editList");
            intent.putExtra("listName", listName);
            startActivity(intent);
            finish();
        }
        if (id == 4) {
            Intent intent = new Intent(this, Host_Playlist_Manage.class);
            intent.putExtra("sendFrom", "editList");
            intent.putExtra("listName", listName);
            startActivity(intent);
        }
    }

}

/*    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof SongListFragment) {
            SongListFragment songlistFragment = (SongListFragment) fragment;

            songlistFragment.setOnSongListSelectedListener(this);
            SongListRecyclerViewAdapter adapter = new SongListRecyclerViewAdapter(items, this);
        }
    }
}*/
