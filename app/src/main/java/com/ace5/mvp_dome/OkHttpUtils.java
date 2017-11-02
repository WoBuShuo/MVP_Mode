package com.ace5.mvp_dome;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Environment;


import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


/**
 * OkHttp下载工具类
 */
public class OkHttpUtils {

    // private static final String TAG = OkHttpUtils.class.getSimpleName();
    private static final int cacheSize = 10 * 1024 * 1024; // 缓存大小10 MB
    public static final int SUCCESS = 1000;
    public static final int FAILURE = -1000;
    public static final String SUCCESS_KEY = "response";
    public static final String FAILURE_KEY = "failure";
    public static final int TIME_OUT = 5; // 请求超时 5 秒
    public static Cache mCache;
    public static Cache mOkHttpClient;

    public static void init() {
        File cacheDir = Environment.getDownloadCacheDirectory();
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            cacheDir = Environment.getExternalStorageDirectory();
        }
        mCache = new Cache(cacheDir, cacheSize);





    }


    /**
     * get下载返回JsonObject
     *
     * @param url         传入的url
     */
    public static void getJson(String url,
                               Callback callBack) {
        Request request =new Request.Builder().url(url).build();
        OkHttpClient client=new OkHttpClient();
        client.newCall(request).enqueue(callBack);
    }





}
