package com.ace5.mvp_dome.base;

/**
 * Created by sos on 2017/11/1.
 */

public class BasePresenter<V extends BaseView> {

    private V mView;

    public void attachView(V view) {
        this.mView = view;
    }

    public void detachView() {
        mView = null;
    }

    public V getView() {
        return mView;
    }
}
