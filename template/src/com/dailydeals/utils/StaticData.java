// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

public class StaticData
{

    public static Context appContext;
    public static String appVersion;
    public static float density;
    public static int height;
    public static SharedPreferences pref;
    public static Resources res;
    public static int screenSize;
    public static int width;

    private StaticData()
    {
    }

    public static void clear()
    {
        System.exit(0);
    }

    public static int getDIP(int i)
    {
        return (int)((float)i * density);
    }

    public static String getUDID()
    {
        return android.provider.Settings.Secure.getString(appContext.getContentResolver(), "android_id");
    }

    public static void init(Activity activity)
    {
        if (appContext != null)
        {
            return;
        }
        appContext = activity.getApplicationContext();
        pref = PreferenceManager.getDefaultSharedPreferences(appContext);
        res = appContext.getResources();
        density = res.getDisplayMetrics().density;
        width = res.getDisplayMetrics().widthPixels;
        height = res.getDisplayMetrics().heightPixels;
        screenSize = 0xf & res.getConfiguration().screenLayout;
        if (screenSize == 4)
        {
            density = 2.0F;
        }
        try
        {
            appVersion = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).versionName;
            return;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            appVersion = "N/A";
            namenotfoundexception.printStackTrace();
            return;
        }
    }
}
