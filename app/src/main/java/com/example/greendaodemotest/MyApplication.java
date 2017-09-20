package com.example.greendaodemotest;

import android.app.Application;
import android.content.Context;

import com.example.greendaodemotest.util.DaoManager;

/**
 * Created by li biao
 * 2017/9/20
 * email:207563927@qq.com
 */

public class MyApplication extends Application
{

    private static Context context;
    @Override
    public void onCreate()
    {
        super.onCreate();
        context = this;
        DaoManager.getInstance().init(this);

    }
    public static Context getContext()
    {
        return context;
    }



}
