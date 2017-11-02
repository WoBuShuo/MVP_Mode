package com.ace5.mvp_dome.base;

/**
 * Created by sos on 2017/11/2.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<V extends BaseView,
        P extends BasePresenter<V>> extends AppCompatActivity {


        private P mPresenter;
        private V mView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mPresenter==null){
            mPresenter=createPresenter();
        }

        if (mView==null){
            mView=createView();
        }
        if (mPresenter==null){
            throw  new NullPointerException("p不能为空");
        }
        if (mView==null){
            throw  new NullPointerException("v不能为空");
        }
        //p层绑定v层
        mPresenter.attachView(mView);
    }


    //可能会有很多p和v层，这个由子类实现创建v跟p
    public abstract  P createPresenter();

    public abstract  V createView();

    public P getPresenter() {
        return mPresenter;
    }

    //解绑当activity销毁就不再更新ui
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null){
            mPresenter.detachView();
        }
    }
}
