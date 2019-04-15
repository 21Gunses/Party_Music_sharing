package com.csci5115.activities;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment3 extends Fragment {
    OnClickListener callback;

    public void setOnClickListenerListener(OnClickListener callback) { this.callback = callback; }

    public interface OnClickListener {
        public void onClicked(int id);
    }

    public BlankFragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment3, container, false);

        ImageButton btn = view.findViewById(R.id.check_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onClicked(4);
            }
        });

        return view;
    }

}