package com.ace5.mvp_dome.presenter;

import com.ace5.mvp_dome.base.BasePresenter;
import com.ace5.mvp_dome.model.Model_1;
import com.ace5.mvp_dome.view.View_1;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by sos on 2017/11/1.
 */

public class Presenter_1 extends BasePresenter<View_1> {
    //持有model引用
    private Model_1 mModel_1;

    public Presenter_1() {
        this.mModel_1 = new Model_1();
    }

    public void callbackRequest(String url) {
        this.mModel_1.netStart(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //将数据回吊到view层
                getView().viewCall(response.body().string());
            }
        });
    }

}
