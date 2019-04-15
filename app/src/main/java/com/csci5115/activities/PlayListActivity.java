package com.csci5115.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.Toast;

import com.csci5115.activities.dummy.DummyContent;

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
        ArrayList<DummyContent.DummyItem> items;
        items = new ArrayList<>();

        items.add(
                new DummyContent.DummyItem(
                        "1",
                        "abc",
                        "efg"
                )
        );

        //
        fragment = new BlankFragment();

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

    public void onSongListSelected( DummyContent.DummyItem item) {
        Toast.makeText(getApplicationContext(), item.content, Toast.LENGTH_SHORT).show();
        SongFragment fragment2 = new SongFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        /*Bundle args = new Bundle();
        args.putParcelableArrayList("items", items);
        fragment.setArguments(args);*/

        ft.replace(R.id.main_frag, fragment2);

        ft.commit();
    }

    public void onSongSelected( DummyContent.DummyItem item) {
        Toast.makeText(getApplicationContext(), item.content, Toast.LENGTH_SHORT).show();
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
