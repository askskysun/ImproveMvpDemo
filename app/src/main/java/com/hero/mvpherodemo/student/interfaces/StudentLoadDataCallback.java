package com.hero.mvpherodemo.student.interfaces;

import com.hero.mvpherodemo.mvp.BaseCallBack;

/**
 *
 */
public interface StudentLoadDataCallback extends BaseCallBack {

    /**
     * 成功回调，更新UI
     * @param successData
     */
    void onSuccess(String successData);

    /**
     * 失败回调，展示失败提示
     * @param errorData
     */
    void onFailure(String errorData);

}
