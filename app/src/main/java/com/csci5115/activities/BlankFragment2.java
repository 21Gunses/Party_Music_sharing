package com.csci5115.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */

public class BlankFragment2 extends Fragment {

    OnClickListener callback;

    public void setOnClickListenerListener2(OnClickListener callback) { this.callback = callback; }

    public interface OnClickListener {
        public void onClicked(int id);
    }

    public BlankFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank_fragment2, container, false);

        Button btn = (Button) view.findViewById(R.id.button);
        Button GoParty = (Button) view.findViewById(R.id.go_party);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onClicked(3);
            }
        });
        GoParty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onClicked(4);
            }
        });

        return view;
    }

}
