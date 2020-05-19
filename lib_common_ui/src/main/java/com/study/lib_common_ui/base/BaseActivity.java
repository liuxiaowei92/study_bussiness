package com.study.lib_common_ui.base;

import android.os.Bundle;

import com.study.lib_common_ui.utils.StatusBarUtil;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

/**
 * @authour lxw
 * @function
 * @date 2020/5/19
 */
public class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtil.statusBarLightMode(this);

    }
}
