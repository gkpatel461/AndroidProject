package com.example.gkpatel.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class EditActivity extends AppCompatActivity {
    Toolbar toolbar;
    TextView edit,send,trash;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edit= (TextView) findViewById(R.id.edit_tv);
        send= (TextView) findViewById(R.id.send_tv_edit);
        trash= (TextView) findViewById(R.id.trash_tv_edit);
        toolbar = (Toolbar)findViewById(R.id.tool_action_bar_edit);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        View view =getSupportActionBar().getCustomView();
        TextView user_name=(TextView)view.findViewById(R.id.user_name_actionbar);
        ImageView plus_actionbar = (ImageView)findViewById(R.id.plus_actionbar);
        plus_actionbar.setVisibility(View.GONE);
        FontStyle.robot_bold_font(this,user_name);
        FontStyle.digital_font(this,edit);
        FontStyle.digital_font(this,send);
        FontStyle.digital_font(this,trash);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivity.this,TabLayoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
