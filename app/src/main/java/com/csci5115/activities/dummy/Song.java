package com.csci5115.activities.dummy;


import android.os.Parcel;
import android.os.Parcelable;
import android.os.Bundle;


public class Song implements Parcelable{
    public String id;
    public String name;
    public String artist;
    public String length;

    public Song(String id, String name, String artist, String length) {
        this.id = id;
        this.name = name;
        this.artist = artist;
        this.length = length;
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
        bundle.putString("artist", this.artist);
        dest.writeBundle(bundle);
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel source) {
            Bundle bundle = source.readBundle();
            Song song = new Song(
                    bundle.getString("id"),
                    bundle.getString("name"),
                    bundle.getString("artist"),
                    bundle.getString("length")
            );
            return song;
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
}
