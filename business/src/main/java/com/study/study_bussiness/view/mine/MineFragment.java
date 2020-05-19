package com.study.study_bussiness.view.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.study.study_bussiness.R;

import java.io.IOException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @authour lxw
 * @function
 * @date 2020/5/18
 */
public class MineFragment extends Fragment {
    public static Fragment getInstance() {
        MineFragment fragment=new MineFragment();
        return fragment;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void okhttpTest() {

        OkHttpClient okHttpClient=new OkHttpClient();
        FormBody.Builder formBody=new FormBody.Builder();
        FormBody build = formBody.build();
        Request.Builder requ=new Request.Builder().url("").post(build);
        Call call = okHttpClient.newCall(requ.build());
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_mine_layout, null);
        return inflate;
    }


}
