package com.example.gkpatel.myapplication;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class TabLayoutActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);

        toolbar = (Toolbar) findViewById(R.id.tool_action_bar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.actionbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setCustomView(R.layout.intro_background);
        tabLayout.getTabAt(1).setCustomView(R.layout.white_background);
        tabLayout.getTabAt(2).setCustomView(R.layout.blue_background);
        View view2 = tabLayout.getTabAt(0).getCustomView();
        TextView intro = (TextView) view2.findViewById(R.id.intro_header_tv);
        FontStyle.robot_bold_font(getApplicationContext(),intro);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view =tab.getCustomView();
                int position = tab.getPosition();
                switch (position)
                {
                    case 0:
                        TextView intro_textView = (TextView) view.findViewById(R.id.intro_header_tv);
                        FontStyle.robot_bold_font(getApplicationContext(),intro_textView);
                        break;
                    case 1:
                        TextView back_textView = (TextView) view.findViewById(R.id.background_header_tv);
                        FontStyle.robot_bold_font(getApplicationContext(),back_textView);
                        break;
                    case 2:
                        TextView end_textView = (TextView) view.findViewById(R.id.end_header_tv);
                        FontStyle.robot_bold_font(getApplicationContext(),end_textView);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view =tab.getCustomView();
                int position = tab.getPosition();
                switch (position)
                {
                    case 0:
                        TextView intro_textView = (TextView) view.findViewById(R.id.intro_header_tv);
                        FontStyle.robot_regular_font(getApplicationContext(),intro_textView);
                        break;
                    case 1:
                        TextView back_textView = (TextView) view.findViewById(R.id.background_header_tv);
                        FontStyle.robot_regular_font(getApplicationContext(),back_textView);
                        break;
                    case 2:
                        TextView end_textView = (TextView) view.findViewById(R.id.end_header_tv);
                        FontStyle.robot_regular_font(getApplicationContext(),end_textView);
                        break;
                }

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        View view =getSupportActionBar().getCustomView();
        TextView user_name=(TextView)view.findViewById(R.id.user_name_actionbar);
        ImageView plus_actionbar = (ImageView)findViewById(R.id.plus_actionbar);
        plus_actionbar.setVisibility(View.GONE);
        FontStyle.robot_bold_font(this,user_name);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new TabIntro(), "INTRO");
        adapter.addFragment(new TabBackground(), "BACKGROUND");
        adapter.addFragment(new TabEnd(), "END");
        viewPager.setAdapter(adapter);
    }




    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
