package com.study.lib_network.response;

import android.os.Handler;
import android.os.Looper;

import com.study.lib_network.exception.OKHttpException;
import com.study.lib_network.listener.DisposeDataHandle;
import com.study.lib_network.listener.DisposeDataListener;
import com.study.lib_network.utils.ResponseEntityToModule;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * @authour lxw
 * @function 处理json类型的响应
 * @date 2020/5/19
 */
public class CommonJsonCallback implements Callback {

    protected  final String EMPTY_MSG="";

    //异常类型
    protected final int NETWORK_ERROR=-1;
    protected final int JSON_ERROR=-2;
    protected final int OTHER_ERROR=-3;

    private DisposeDataListener mListener;
    private Class<?> mClass;
    private Handler mDeliveryHandler;
    public CommonJsonCallback(DisposeDataHandle handle){
        mListener=handle.mListener;
        mClass=handle.mClass;
        //保证handle在主线程
        mDeliveryHandler=new Handler(Looper.getMainLooper());
    }

    @Override
    public void onFailure(Call call, final IOException e) {
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                mListener.onFailure(new OKHttpException(NETWORK_ERROR,e));
            }
        });
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String result=response.body().string();
        mDeliveryHandler.post(new Runnable() {
            @Override
            public void run() {
                handleResponse(result);
            }
        });
    }

    //解析返回的数据
    private void handleResponse(String result) {
        if(result==null || result.trim().equals("")){
            mListener.onFailure(new OKHttpException(NETWORK_ERROR,EMPTY_MSG));
            return;
        }
        try{
            if(mClass==null){
                //不需要解析 直接返回
                mListener.onSuccess(result);
            }else{
                //解析为实体对象  可以用Gson，fastjson等
                Object obj= ResponseEntityToModule.parseJsonToModule(result,mClass);
                if(obj!=null){
                    mListener.onSuccess(obj);
                }else{
                    mListener.onFailure(new OKHttpException(JSON_ERROR,EMPTY_MSG));
                }
            }
        }catch (Exception e){
            mListener.onFailure(new OKHttpException(JSON_ERROR,EMPTY_MSG));
        }
    }
}
