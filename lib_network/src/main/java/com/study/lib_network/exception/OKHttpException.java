package com.study.lib_network.exception;

/**
 * @authour lxw
 * @function 自定义异常类,返回ecode,emsg到业务层
 * @date 2020/5/19
 */
public class OKHttpException extends Exception {
    private static final long serialVersionUID=1L;

    //错误码
    private final int ecode;
    //错误信息
    private final Object emsg;

    public OKHttpException(int ecode, Object emsg){
        this.ecode=ecode;
        this.emsg=emsg;
    }

    public int getEcode() {
        return ecode;
    }

    public Object getEmsg() {
        return emsg;
    }
}
