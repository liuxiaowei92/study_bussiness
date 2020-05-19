package com.study.lib_network.listener;

/**
 * @authour lxw
 * @function
 * @date 2020/5/19
 */
public class DisposeDataHandle {

    public  String mSource=null; //文件保存路径
    public Class<?> mClass=null;
    public DisposeDataListener mListener=null;

    public DisposeDataHandle(DisposeDataListener listener){
        this.mListener=listener;
    }

    public DisposeDataHandle(DisposeDataListener listener,Class<?> clazz){
        this.mListener=listener;
        this.mClass=clazz;
    }
    public DisposeDataHandle(DisposeDataListener listener,String source){
        this.mListener=listener;
        this.mSource=source;
    }


}
