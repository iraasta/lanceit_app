// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.model;


public class DataDeals
{

    private int bgMain;
    private String tv1;
    private String tv2;
    private String tv4;
    private String txt1;
    private String txt2;

    public DataDeals(int i, String s, String s1, String s2, String s3, String s4)
    {
        bgMain = i;
        txt1 = s;
        txt2 = s1;
        tv1 = s2;
        tv2 = s3;
        tv4 = s4;
    }

    public int getBgMain()
    {
        return bgMain;
    }

    public String getTv1()
    {
        return tv1;
    }

    public String getTv2()
    {
        return tv2;
    }

    public String getTv4()
    {
        return tv4;
    }

    public String getTxt1()
    {
        return txt1;
    }

    public String getTxt2()
    {
        return txt2;
    }
}
