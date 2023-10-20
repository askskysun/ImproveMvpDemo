package com.hero.mvpherodemo.mvp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.hero.mvpherodemo.base.BaseActivity;

/**
 * <pre>
 *
 * </pre>
 */
public abstract class BaseMvpActivity<V extends BaseView, P extends BasePresenter> extends BaseActivity implements BaseView{
    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }

    /**
     * 初始化Presenter
     */
    private void initPresenter() {
        presenter = createPresenter();
        presenter.attachView((V) this);
    }

    /**
     * 创建Presenter
     *
     * @return
     */
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public Context getContext() {
        return this;
    }
}