package com.ace5.mvp_dome.model;

import com.ace5.mvp_dome.OkHttpUtils;

import okhttp3.Callback;

/**
 * model层进行数据的获取，网络请求，数据库读取等等
 */
public class Model_1 {
    public void netStart(String url, Callback callback){
        OkHttpUtils.getJson(url,callback);
    }
}
