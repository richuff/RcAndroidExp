package com.richuff.server.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.richuff.server.fragment.TestFragment;

public class LauchImproveAdapter extends FragmentPagerAdapter {

    private int[] mImageArray;

    public LauchImproveAdapter(@NonNull FragmentManager fm,int[] launchImage) {
        super(fm,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.mImageArray = launchImage;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(mImageArray.length,position,mImageArray[position]);
    }

    @Override
    public int getCount() {
        return mImageArray.length;
    }
}
