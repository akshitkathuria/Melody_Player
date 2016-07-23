package com.example.boyzz.melody_player;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by boyzz on 7/11/16.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter
{
    private ArrayList<Fragment> mFragmentsList = new ArrayList<>();
    private ArrayList<String> mFragmentsListTitles = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        return mFragmentsList.get(position);
    }

    @Override
    public int getCount()
    {
        return mFragmentsList.size();
    }

    public void addFragment(Fragment fragment,String title)
    {
        mFragmentsList.add(fragment);
        mFragmentsListTitles.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return mFragmentsListTitles.get(position);
    }
}
