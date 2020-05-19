package com.study.lib_network.listener;

/**
 * @authour lxw
 * @function 监听下载进度
 * @date 2020/5/19
 */
public interface DisposeDownloadListener extends DisposeDataListener {
    void onProgress(int progress);
}
