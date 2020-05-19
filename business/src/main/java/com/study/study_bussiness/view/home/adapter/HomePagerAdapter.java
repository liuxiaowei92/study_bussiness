package com.study.study_bussiness.view.home.adapter;

import com.study.study_bussiness.model.CHANNEL;
import com.study.study_bussiness.view.discory.DiscoryFragment;
import com.study.study_bussiness.view.friend.FriendFragment;
import com.study.study_bussiness.view.mine.MineFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 首页viewpager adapter
 *
 * @authour lxw
 * @function
 * @date 2020/5/18
 */
public class HomePagerAdapter extends FragmentPagerAdapter {

    private final CHANNEL[] mList;

    public HomePagerAdapter(FragmentManager fm, CHANNEL[] data) {
        super(fm);
        mList = data;
    }

    @Override
    public Fragment getItem(int position) {
        int type = mList[position].getValue();
        //初始化对应的fragment
        switch (type) {
            case CHANNEL.MINE_ID:
                return MineFragment.getInstance();
            case CHANNEL.DISCORY_ID:
                return DiscoryFragment.getInstance();
            case CHANNEL.FRIEND_ID:
                return FriendFragment.getInstance();
            default:
                MineFragment.getInstance();
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.length;
    }
}
