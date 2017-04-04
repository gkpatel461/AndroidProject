package com.example.gkpatel.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by gkpatel on 28/3/17.
 */

public class TabPageAdpter extends FragmentStatePagerAdapter {
    public TabPageAdpter(FragmentManager fm, int tabCount) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                TabIntro tabIntro = new TabIntro();
                return tabIntro;

            case 1:
                TabBackground tabBackground = new TabBackground();

                return  tabBackground;
            case 2:
                TabEnd tabEnd = new TabEnd();

                return tabEnd;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
