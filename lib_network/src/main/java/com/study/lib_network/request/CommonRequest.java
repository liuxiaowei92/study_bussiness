package com.study.lib_network.request;

import java.io.File;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * @authour lxw
 * @function 对外提供get/post/文件上传 请求
 * @date 2020/5/19
 */
public class CommonRequest {

    /**
     * 对外创建post 请求对象 无请求头参数
     * @param url
     * @param params
     * @return
     */
    public static Request createPostRequest(String url, RequestParams params){
        return createPostRequest(url,params,null);
    }
    /**
     * 对外创建post 请求对象
     * @param url
     * @param params 请求参数
     * @param headers
     * @return
     */
    public static Request createPostRequest(String url, RequestParams params, RequestParams headers) {
        FormBody.Builder mFormBodyBuilder = new FormBody.Builder();
        if (params != null) {
            //参数遍历
            for (Map.Entry<String, String> entry : params.urlParams.entrySet()) {
                mFormBodyBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        Headers.Builder mHeaderBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                mHeaderBuilder.add(entry.getKey(), entry.getValue());
            }
        }
        Request request=new Request.Builder()
                .url(url)
                .post(mFormBodyBuilder.build())
                .headers(mHeaderBuilder.build())
                .build();
        return request;
    }

    public static Request createGetRequest(String url,RequestParams params){
        return createGetRequest(url,params,null);
    }
    /**
     * 对外创建带请求头的get请求
     * @param url
     * @param params
     * @param headers
     * @return
     */
    public static Request createGetRequest(String url,RequestParams params,RequestParams headers){
        StringBuilder urlBuilder=new StringBuilder(url).append("?");
        if(params!=null){
            for (Map.Entry<String,String> entry:params.urlParams.entrySet()){
                urlBuilder.append(entry.getKey())
                        .append("=")
                        .append(entry.getValue());
            }
        }
        Headers.Builder mHeaderBuilder = new Headers.Builder();
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.urlParams.entrySet()) {
                mHeaderBuilder.add(entry.getKey(), entry.getValue());
            }
        }

        return new Request.Builder()
                .url(urlBuilder.toString())
                .headers(mHeaderBuilder.build())
                .get()
                .build();
    }

    public static final MediaType FILE_TYPE=MediaType.parse("application/octet-stream");
    /**
     * 文件上传请求
     * @param url
     * @param params
     * @return
     */
    public static Request createMultiPostRequest(String url,RequestParams params){
        MultipartBody.Builder multipartBody=new MultipartBody.Builder();
        multipartBody.setType(MultipartBody.FORM);
        if(params!=null){
            for(Map.Entry<String,Object> entry:params.fileParams.entrySet()){
                if(entry.getValue() instanceof File){
                    multipartBody.addPart(Headers.of("content-Disposition","form-data;name=\""+entry.getKey()+"\"")
                            , RequestBody.create(FILE_TYPE,(File) entry.getValue()));
                }else if(entry.getValue() instanceof String){
                    multipartBody.addPart(Headers.of("content-Disposition","form-data;name=\""+entry.getKey()+"\""),
                            RequestBody.create(null,(String)entry.getValue()));
                }
            }
        }
        return new Request.Builder()
                .url(url)
                .post(multipartBody.build())
                .build();

    }

}
