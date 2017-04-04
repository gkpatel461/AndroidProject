package com.example.gkpatel.myapplication;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

public class TabActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{
    ViewPager viewpager;
    TabLayout tabLayout;
    Toolbar toolbar;
    private TabPageAdpter mAdapter;
    // Tab titles
    private String[] tabs = { "INTRO", "BACKGROUND", "END" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        viewpager= (ViewPager) findViewById(R.id.pagger);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        toolbar= (Toolbar) findViewById(R.id.tool_action_bar);

        mAdapter = new TabPageAdpter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewpager.setAdapter(mAdapter);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        tabLayout.addTab(tabLayout.newTab().setText("INTRO"));
        tabLayout.addTab(tabLayout.newTab().setText("BACKGROUND"));
        tabLayout.addTab(tabLayout.newTab().setText("END"));
        tabLayout.setOnTabSelectedListener(this);

    }


    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewpager.setCurrentItem(tab.getPosition());

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
