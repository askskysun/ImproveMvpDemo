package com.hero.mvpherodemo.mvp;

import java.lang.ref.WeakReference;

/**
 * <pre>
 *
 * </pre>
 */
public abstract class BaseModel<I extends BaseCallBack> {
    protected WeakReference<I> iCallBackWeakRef;

    public BaseModel(I iCallBack) {
        iCallBackWeakRef = new WeakReference<>(iCallBack);
    }

    public I getCallBack() {
        if (iCallBackWeakRef != null) {
            return iCallBackWeakRef.get();
        }
        return null;
    }

    /**
     * 回调接口是否有被回收
     *
     * @return
     */
    public boolean isCallBackDestory() {
        if (iCallBackWeakRef == null) {
            return true;
        }

        I iCallBack = iCallBackWeakRef.get();
        if (iCallBack == null) {
            return true;
        }

        return false;
    }

    /**
     * 提供回收方法
     * 子类可继承，处理取消请求、资源加载等
     */
    public void destory() {
        if (iCallBackWeakRef == null) {
            return;
        }

        I iCallBack = iCallBackWeakRef.get();
        if (iCallBack != null) {
            iCallBackWeakRef.clear();
        }
        iCallBackWeakRef = null;
    }
}
