package com.study.lib_network;

import com.study.lib_network.listener.DisposeDataHandle;
import com.study.lib_network.response.CommonFileCallback;
import com.study.lib_network.response.CommonJsonCallback;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

import okhttp3.Call;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @authour lxw
 * @function 用来发送get,post请求的工具类
 * @date 2020/5/19
 */
public class CommonOkHttpClient {
    private static final int TIME_OUT=30;
    private static OkHttpClient mOkhttpClient;
    //初始化
    static{
        OkHttpClient.Builder okHttpClientBuilder=new OkHttpClient.Builder();
        okHttpClientBuilder.hostnameVerifier(new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        /**
         * 添加公共请求头
         */
        okHttpClientBuilder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request=chain.request().newBuilder()
                        .addHeader("User-agent","Imooc-Mobile").build();
                return chain.proceed(request);
            }
        });
        okHttpClientBuilder.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        okHttpClientBuilder.followRedirects(true);
        mOkhttpClient=okHttpClientBuilder.build();
    }

    /**
     * get请求
     * @return
     */
    public static Call get(Request request, DisposeDataHandle handle){
        Call call=mOkhttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

    /**
     * post请求 文件上传
     * @return
     */
    public static Call post(Request request, DisposeDataHandle handle){
        Call call=mOkhttpClient.newCall(request);
        call.enqueue(new CommonJsonCallback(handle));
        return call;
    }

    /**
     * 文件下载请求
     * @return
     */
    public static Call downloadFile(Request request,DisposeDataHandle handle){
        Call call = mOkhttpClient.newCall(request);
        call.enqueue(new CommonFileCallback(handle));
        return call;
    }




}
