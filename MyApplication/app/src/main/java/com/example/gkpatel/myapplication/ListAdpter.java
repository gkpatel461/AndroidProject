package com.example.gkpatel.myapplication;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by gkpatel on 30/3/17.
 */

public class ListAdpter extends BaseExpandableListAdapter {

    public Context context;
    private List<String> parent_list;
    private HashMap<String, List<String>> child_list;


    public ListAdpter(Context context, List<String> parent_list, HashMap<String ,List<String>> child_list) {
        this.context = context;
        this.parent_list = parent_list;
        this.child_list = child_list;

    }


    @Override
    public int getGroupCount() {
        return this.parent_list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.child_list.get(this.parent_list.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.parent_list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.child_list.get(this.parent_list.get(groupPosition))
                .get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.raw_layout,null);
        }
        TextView parent_list_item = (TextView) convertView.findViewById(R.id.list_raw_tv);
        parent_list_item.setTypeface(null, Typeface.BOLD);
        parent_list_item.setText(headerTitle);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

            if (convertView == null)
            {
                LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.expanded_raw,null);
            }

            TextView child_list_item = (TextView) convertView.findViewById(R.id.expanded_list_raw_tv);
            final ImageView imageView = (ImageView) convertView.findViewById(R.id.plus_tab_list);

            child_list_item.setText(childText);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
