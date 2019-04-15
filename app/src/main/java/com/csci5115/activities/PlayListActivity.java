package com.csci5115.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

import com.csci5115.activities.dummy.DummyContent;
import com.csci5115.activities.dummy.SongList;
import com.csci5115.activities.dummy.Song;

import java.util.ArrayList;
import java.util.List;

public class PlayListActivity extends AppCompatActivity
    implements SongListFragment.OnListFragmentInteractionListener,
        SongFragment.OnListFragmentInteractionListener,
        BlankFragment.OnClickListener{

    private Fragment fragment = null;
    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction tf = fm.beginTransaction();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        //Get the fragment manager for this activity (MainActivity)
        //FragmentTransaction tf = getSupportFragmentManager().beginTransaction();
        ArrayList<SongList> items;
        items = new ArrayList<>();

        ArrayList<Song> song_list = new ArrayList<>();
        for (int i = 0; i < 5; i++){
            song_list.add(new Song("" + i,"song" + i, "artist"+i, "4:00"));
        }

        items.add(new SongList("1","list1", 5,"20:00",song_list));
        items.add(new SongList("2","list2", 5,"20:00", song_list));
        items.add(new SongList("3","list3", 5,"20:00", song_list));
        items.add(new SongList("4","list4", 5,"20:00",song_list));


        fragment = new SongListFragment();

        Bundle args = new Bundle();
        args.putParcelableArrayList("items", items);
        fragment.setArguments(args);

        tf.add(R.id.main_frag, fragment);

        tf.commit();
        /*ft.add(R.id.f_layout,f,"");
        ft.commit();*/

    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof BlankFragment) {
            BlankFragment f = (BlankFragment) fragment;
            f.setOnClickListenerListener(this);
        }
    }

    public void onSongListSelected( SongList item) {
        Toast.makeText(getApplicationContext(), item.name, Toast.LENGTH_SHORT).show();
        SongFragment fragment2 = new SongFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Bundle args = new Bundle();
        args.putParcelableArrayList("songs", item.song_list);
        fragment2.setArguments(args);

        ft.replace(R.id.main_frag, fragment2);

        ft.commit();
    }

    public void onSongSelected( Song item) {
        Toast.makeText(getApplicationContext(), item.name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClicked(int id){
        if (id == 2) {
            fragment = new SongListFragment();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.main_frag, fragment);
            ft.commit();
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
