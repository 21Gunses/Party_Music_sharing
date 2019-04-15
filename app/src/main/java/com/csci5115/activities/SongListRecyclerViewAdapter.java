package com.csci5115.activities;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.csci5115.activities.SongListFragment.OnListFragmentInteractionListener;
import com.csci5115.activities.dummy.DummyContent.DummyItem;
import com.csci5115.activities.dummy.SongList;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class SongListRecyclerViewAdapter extends RecyclerView.Adapter<SongListRecyclerViewAdapter.ViewHolder> {

    private final List<SongList> mValues;
    private final OnListFragmentInteractionListener mListener;

    public SongListRecyclerViewAdapter(List<SongList> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_songlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mNameView.setText(mValues.get(position).name);
        holder.mNumView.setText(mValues.get(position).nSong);
        holder.mTimeView.setText(mValues.get(position).length);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onSongListSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mNameView;
        public final TextView mNumView;
        public final TextView mTimeView;
        public SongList mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mNameView = (TextView) view.findViewById(R.id.name);
            mNumView = (TextView) view.findViewById(R.id.song_num);
            mTimeView = (TextView) view.findViewById(R.id.total_time);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mNameView.getText() + "'";
        }
    }
}
