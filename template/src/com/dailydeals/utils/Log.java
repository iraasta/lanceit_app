// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;


public class Log
{

    public Log()
    {
    }

    public static void e(Object obj)
    {
        e("TAG", (new StringBuilder()).append(obj).toString());
    }

    public static void e(String s, Object obj)
    {
        android.util.Log.e(s, (new StringBuilder()).append(obj).toString());
    }

    public static void e(String s, Object aobj[])
    {
        StringBuffer stringbuffer = new StringBuffer();
        int i = aobj.length;
        int j = 0;
        do
        {
            if (j >= i)
            {
                e(s, stringbuffer);
                return;
            }
            Object obj = aobj[j];
            stringbuffer.append((new StringBuilder()).append(obj).append("__").toString());
            j++;
        } while (true);
    }

    public static void e(Object aobj[])
    {
        e("TAG", aobj);
    }
}
