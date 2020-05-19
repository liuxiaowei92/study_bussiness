package com.study.lib_network.listener;

/**
 * @authour lxw
 * @function 业务逻辑层真正处理的地方 ，包括java层异常业务层异常
 * @date 2020/5/19
 */
public interface DisposeDataListener {

    /**
     * 请求成功回调事件
     * @param reponseObj
     */
    void onSuccess(Object reponseObj);

    /**
     * 请求失败回调事件
     * @param reasonObj
     */
    void onFailure(Object reasonObj);

}
