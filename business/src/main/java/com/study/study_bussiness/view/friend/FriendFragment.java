package com.study.study_bussiness.view.friend;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.study_bussiness.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @authour lxw
 * @function
 * @date 2020/5/18
 */
public class FriendFragment extends Fragment {
    public static Fragment getInstance() {
        FriendFragment fragment=new FriendFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate =  inflater.inflate(R.layout.fragment_friend_layout,null);
        return inflate;
    }


}
