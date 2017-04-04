package com.example.gkpatel.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class StopActivity extends AppCompatActivity {
    TextView stop,send,trash;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop);

        stop= (TextView) findViewById(R.id.stop_tv);
        send= (TextView) findViewById(R.id.send_tv_stop);
        trash= (TextView) findViewById(R.id.trash_tv_stop);
        toolbar = (Toolbar)findViewById(R.id.tool_action_bar_stop);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        View view =getSupportActionBar().getCustomView();
        ImageView plus_actionbar= (ImageView) view.findViewById(R.id.plus_actionbar);
        TextView user_name=(TextView)view.findViewById(R.id.user_name_actionbar);
        TextView recording=(TextView)view.findViewById(R.id.recording_tv);
        plus_actionbar.setVisibility(View.GONE);


        FontStyle.robot_bold_font(this,user_name);
        FontStyle.digital_font(this,stop);
        FontStyle.digital_font(this,send);
        FontStyle.digital_font(this,trash);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(StopActivity.this,EditActivity.class);
                startActivity(i);
            }
        });

    }
}
