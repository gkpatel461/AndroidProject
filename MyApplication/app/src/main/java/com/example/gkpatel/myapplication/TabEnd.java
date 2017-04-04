package com.example.gkpatel.myapplication;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gkpatel on 29/3/17.
 */

public class TabEnd extends Fragment {

    public TabEnd() {
        // Required empty public constructor
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override

    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        return inflater.inflate(R.layout.tab_end, container, false);
    }
}
