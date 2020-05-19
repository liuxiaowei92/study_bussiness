package com.study.study_bussiness.api;

import com.study.lib_network.CommonOkHttpClient;
import com.study.lib_network.listener.DisposeDataHandle;
import com.study.lib_network.listener.DisposeDataListener;
import com.study.lib_network.request.CommonRequest;
import com.study.lib_network.request.RequestParams;
import com.study.study_bussiness.model.user.User;

/**
 * @authour lxw
 * @function 请求中心
 * @date 2020/5/19
 */
public class RequestCenter {
    static class HttpConstants{
        private static final String ROOT_URL="http://imooc.com/api";

        /**
         * 首页请求接口
         */
        private static String HOME_RECOMMAND = ROOT_URL + "/module_voice/home_recommand";

        private static String HOME_RECOMMAND_MORE = ROOT_URL + "/module_voice/home_recommand_more";

        private static String HOME_FRIEND = ROOT_URL + "/module_voice/home_friend";

        /**
         * 登陆接口
         */
        public static String LOGIN = ROOT_URL + "/module_voice/login_phone";
    }

    public static void postResquest(String url, RequestParams params
            , DisposeDataListener listener, Class<?> clazz){
        CommonOkHttpClient.post(CommonRequest.createPostRequest(url,params)
                ,new DisposeDataHandle(listener,clazz));
    }

    /**
     * 用户登录
     */
    public static void login(DisposeDataListener listener){
        RequestParams params=new RequestParams();
        params.put("mb","19734924592");
        params.put("pwd","999999q");
        RequestCenter.postResquest(HttpConstants.LOGIN,params,listener, User.class);
    }



}
