package com.example.gkpatel.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gkpatel on 30/3/17.
 */

public class ExpandedListAdpter extends RecyclerView.Adapter<ExpandedListAdpter.ViewHolder>
{

    Context context;
    List<String> list = new ArrayList<String>();;
    public ExpandedListAdpter(Context context,List<String> list)
    {

        this.context =context;
        this.list = list;
    }


//    @Override
//    public ViewHolder  onCreateViewHolder(ViewGroup parent, int viewType) {
//        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View cardView = inflater.inflate(R.layout.expanded_raw, null, false);
//        ViewHolder viewHolder = new ViewHolder(cardView);
//        return viewHolder;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.expanded_raw,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExpandedListAdpter.ViewHolder holder, int position) {
        TextView modelTextView = (TextView) holder.voice_name;
        modelTextView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView voice_name;
        public ViewHolder(View itemView) {
            super(itemView);
            voice_name = (TextView) itemView.findViewById(R.id.expanded_list_raw_tv);

        }
    }
}