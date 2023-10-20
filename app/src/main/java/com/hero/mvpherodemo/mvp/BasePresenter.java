package com.hero.mvpherodemo.mvp;

import android.app.Activity;

import java.lang.ref.WeakReference;

/**
 * <pre>
 * presenter基类
 * </pre>
 */
public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    private WeakReference<V> iViewWeakRef;
    protected M model;

    public BasePresenter() {
        model = createModel(this);
    }

    protected abstract M createModel(BasePresenter presenter);

    /**
     * 获取一个view的引用
     *
     * @return
     */
    public V getMvpView() {
        if (iViewWeakRef == null) {
            return null;
        }

        return iViewWeakRef.get();
    }

    /**
     * View是否有被回收
     *
     * @return
     */
    public boolean isViewDestory() {
        if (iViewWeakRef == null) {
            return true;
        }

        V view = iViewWeakRef.get();
        if (view == null) {
            return true;
        }
        if (view instanceof Activity) {
            Activity activity = (Activity) view;
            if (activity.isDestroyed() || activity.isFinishing()) {
                return true;
            }
        }

        return false;
    }

    /**
     * 绑定mvp的View接口
     *
     * @param mvpView
     */
    public void attachView(V mvpView) {
        iViewWeakRef = new WeakReference<>(mvpView);
    }

    /**
     * 与view解绑
     */
    public void detachView() {
        if (iViewWeakRef != null) {
            iViewWeakRef.clear();
        }
        iViewWeakRef = null;
        model.destory();
    }
}