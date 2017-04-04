package com.example.gkpatel.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by gkpatel on 29/3/17.
 */

public class TabBackground extends Fragment {
    ExpandableListView expandableListView ;
    ListAdpter listAdpter;
    public List<String> parent_list;
    Context context;
    public HashMap<String, List<String>> child_list;

    public TabBackground() {
        // Required empty public constructor
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_background, container, false);
        expandableListView = (ExpandableListView) view.findViewById(R.id.list_background);

        parent_list = new ArrayList<String>();
        parent_list.add("voice 1");
        parent_list.add("Voice 2");
        parent_list.add("voice 3");
        parent_list.add("voice 4");
        parent_list.add("voice 5");

        child_list = new HashMap<String, List<String>>();

        List<String> voice_1 = new ArrayList<String>();
        voice_1.add("in_voice 1");
        voice_1.add("in_voice 2");
        voice_1.add("in_voice 3");
        voice_1.add("in_voice 4");
        voice_1.add("in_voice 5");

        List<String> voice_2 = new ArrayList<String>();
        voice_2.add("in_voice 1");
        voice_2.add("in_voice 2");
        voice_2.add("in_voice 3");
        voice_2.add("in_voice 4");
        voice_2.add("in_voice 5");

        List<String> voice_3 = new ArrayList<String>();
        voice_3.add("in_voice 1");
        voice_3.add("in_voice 2");
        voice_3.add("in_voice 3");
        voice_3.add("in_voice 4");
        voice_3.add("in_voice 5");

        List<String> voice_4 = new ArrayList<String>();
        voice_4.add("in_voice 1");
        voice_4.add("in_voice 2");
        voice_4.add("in_voice 3");
        voice_4.add("in_voice 4");
        voice_4.add("in_voice 5");

        List<String> voice_5 = new ArrayList<String>();
        voice_5.add("in_voice 1");
        voice_5.add("in_voice 2");
        voice_5.add("in_voice 3");
        voice_5.add("in_voice 4");
        voice_5.add("in_voice 5");
        child_list.put(parent_list.get(0), voice_1);
        child_list.put(parent_list.get(1), voice_2);
        child_list.put(parent_list.get(2), voice_3);
        child_list.put(parent_list.get(3), voice_4);
        child_list.put(parent_list.get(4), voice_5);


        listAdpter = new ListAdpter(getContext(), parent_list,child_list);
        expandableListView.setAdapter(listAdpter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {


                Toast.makeText(
                            getContext(),
                            parent_list.get(groupPosition)
                                    + " : "
                                    + child_list.get(
                                    parent_list.get(groupPosition)).get(
                                    childPosition), Toast.LENGTH_SHORT)
                            .show();
                return true;
            }
        });
        expandableListView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;
            @Override
            public void onGroupExpand(int groupPosition) {
                if ((previousGroup != -1) && (groupPosition != previousGroup)) {
                    expandableListView.collapseGroup(previousGroup);
                }
                previousGroup = groupPosition;
            }
        });
        return view;
    }
}
