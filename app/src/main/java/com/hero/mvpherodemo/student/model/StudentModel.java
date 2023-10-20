package com.hero.mvpherodemo.student.model;

import android.os.Handler;
import android.text.TextUtils;


import com.hero.mvpherodemo.mvp.BaseModel;
import com.hero.mvpherodemo.student.contract.StudentContract;
import com.hero.mvpherodemo.student.interfaces.StudentLoadDataCallback;

import java.util.Map;

/**
 * Model层
 */
public class StudentModel extends BaseModel<StudentLoadDataCallback> implements StudentContract.Model{

    public StudentModel(StudentLoadDataCallback iCallBack) {
        super(iCallBack);
    }

    @Override
    public void executeGetRequest(String url) {
        /**
         * 模拟网络请求耗时操作
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /**
                 * 从服务端请求回来的字符串数据：
                 * 为了增加通用性，建议以请求回来的原有数据返回给View层，由View层做具体的数据解析、UI展示处理
                 */
                String data = "{\n"
                    + "  \"mData\":\"红日\",\n"
                    + "  \"gender\": \"男士\",\n"
                    + "  \"age\":18\n"
                    + "}";
                if (isCallBackDestory()) {
                    return;
                }

                if (!TextUtils.isEmpty(data)) {
                    getCallBack().onSuccess(data);
                } else {
                    data = "数据获取失败";
                    getCallBack().onFailure(data);
                }
            }
        }, 1000);
    }

    @Override
    public void executePostRequest(String url, Map params) {

    }
}
