package com.hero.mvpherodemo.mvp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.hero.mvpherodemo.base.BaseFragment;

/**
 * <pre>
 *
 * </pre>
 */
public abstract class BaseMvpFragment<V extends BaseView, P extends BasePresenter> extends BaseFragment {
    public P presenter;

    @Nullable
    @org.jetbrains.annotations.Nullable
    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        initPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
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
    public abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }
}