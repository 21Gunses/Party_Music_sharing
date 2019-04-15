package com.csci5115.activities.dummy;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;

import java.util.ArrayList;


public class SongList implements Parcelable{
    public String id;
    public String name;
    public String nSong;
    public String length;
    public ArrayList<Song> song_list;

    public SongList(String id, String name, String nSong,
                    String length, ArrayList<Song> song_list) {
        this.id = id;
        this.name = name;
        this.nSong = nSong;
        this.length = length;
        this.song_list = song_list;
    }

    public SongList(Parcel in){
        Bundle bundle = in.readBundle();
        this.id = bundle.getString("id");
        this.name = bundle.getString("name");
        this.nSong = bundle.getString("nSong");
        this.length = bundle.getString("length");
        in.readTypedList(this.song_list, Song.CREATOR);
    }


    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle = new Bundle();
        bundle.putString("id", this.id);
        bundle.putString("name", this.name);
        bundle.putString("length", this.length);
        bundle.putString("nSong", this.nSong);
        dest.writeBundle(bundle);
        dest.writeTypedList(song_list);
    }

    public static final Creator<SongList> CREATOR = new Creator<SongList>() {
        @Override
        public SongList createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();

            SongList songlist = new SongList(source);
            return songlist;
        }

        @Override
        public SongList[] newArray(int size) {
            return new SongList[size];
        }
    };
}
