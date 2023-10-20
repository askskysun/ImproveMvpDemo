package com.hero.mvpherodemo.student.contract;


import com.hero.mvpherodemo.mvp.BaseCallBack;
import com.hero.mvpherodemo.mvp.BaseModel;
import com.hero.mvpherodemo.mvp.BasePresenter;
import com.hero.mvpherodemo.mvp.BaseView;
import com.hero.mvpherodemo.student.interfaces.StudentLoadDataCallback;

import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 */
public interface StudentContract {
    interface Model {

        /***
         * 执行Get网络请求
         * @param url
         */
        void executeGetRequest(String url);

        /**
         * 执行Post网络请求
         *
         * @param url
         * @param params
         */
        void executePostRequest(String url, Map params);
    }

    interface View extends BaseView {
        /**
         * 展示通用页面Loading
         */
        void showLoading();

        /**
         * 取消通用页面Loading
         */
        void dismissLoading();

        /**
         * 业务方数据成功获取后，调用此方法更新UI
         *
         * @param data
         */
        void showSuccessData(String data);

        /**
         * 业务方数据获取失败后，调用此方法展示失败页面UI
         *
         * @param data
         */
        void showFailureData(String data);
    }

    interface Presenter {
        void requestData(String url);
    }
}
