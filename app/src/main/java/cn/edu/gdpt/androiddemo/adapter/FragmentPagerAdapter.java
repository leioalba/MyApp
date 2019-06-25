package cn.edu.gdpt.androiddemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import cn.edu.gdpt.androiddemo.fragment.CoverterFragment;
import cn.edu.gdpt.androiddemo.fragment.HomeFragment;

public class FragmentPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
    private String[] mTitles = new String[]{"市场汇率", "汇率转换"};
    public FragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        if (i == 1)
            return new CoverterFragment();

        return new HomeFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
