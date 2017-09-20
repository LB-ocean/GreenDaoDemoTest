package com.example.greendaodemotest.util;

import android.util.Log;

public class MyLog
{
    public static boolean debugMode = true;

    public static void v(String info)
    {
        if(debugMode)
        {
            Log.v("TAG",info);
        }
    }
    public static void e(String info)
    {
        if(debugMode)
        {
            Log.e("TAG",info);
        }
    }
    public static void w(String info)
    {
        if(debugMode)
        {
            Log.w("TAG",info);
        }
    }
}
