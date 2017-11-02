package com.ace5.mvp_dome;

import android.os.Bundle;
import android.view.View;

import com.ace5.mvp_dome.base.BaseActivity;
import com.ace5.mvp_dome.R;
import com.ace5.mvp_dome.presenter.Presenter_1;
import com.ace5.mvp_dome.view.View_1;

public class MainActivity extends BaseActivity<View_1,Presenter_1> implements View_1{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public Presenter_1 createPresenter() {
        return new Presenter_1();
    }

    @Override
    public View_1 createView() {
        return this;
    }


    public void start(View view) {
        getPresenter().callbackRequest("");
    }

    @Override
    public void viewCall(String result) {
        //注意，这里我用okhttp异步请求，这里是子线程，不能更新ui，需要使用转换到主线程更新
        //可以使用rxjava在model里面转化
    }
}
