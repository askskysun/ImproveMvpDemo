package com.hero.mvpherodemo.student.presenter;

import android.content.Context;

import com.hero.mvpherodemo.mvp.BasePresenter;
import com.hero.mvpherodemo.student.contract.StudentContract;
import com.hero.mvpherodemo.student.interfaces.StudentLoadDataCallback;
import com.hero.mvpherodemo.student.model.StudentModel;

/**
 * Presenter层
 */
public class StudentPresenter extends BasePresenter<StudentContract.View, StudentModel> implements StudentContract.Presenter, StudentLoadDataCallback {

    @Override
    protected StudentModel createModel(BasePresenter presenter) {
        return new StudentModel(this);
    }

    /**
     * 请求数据入口
     * @param url
     */
    @Override
    public void requestData(String url) {
        if (isViewDestory()) {
            return;
        }

        getMvpView().showLoading();
        model.executeGetRequest(url);
    }

    /**
     * 数据请求成功--更新UI
     * @param successData
     */
    @Override
    public void onSuccess(String successData) {
        if (isViewDestory()) {
           return;
        }
        getMvpView().dismissLoading();
        getMvpView().showSuccessData(successData);
    }

    /**
     * 数据请求失败--更新展示错误页面UI
     * @param errorData
     */
    @Override
    public void onFailure(String errorData) {
        if (isViewDestory()) {
            return;
        }
        getMvpView().dismissLoading();
        getMvpView().showFailureData(errorData);
    }

    @Override
    public Context getContext() {
        if (!isViewDestory()) {
            return getMvpView().getContext();
        }

        return null;
    }
}
