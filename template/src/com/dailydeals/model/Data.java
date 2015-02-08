// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.model;


public class Data
{

    private int image;
    private int imageSelected;
    private String sel;
    private String title;

    public Data(String s, int i, int j)
    {
        title = s;
        image = i;
        imageSelected = j;
    }

    public int getImage()
    {
        return image;
    }

    public int getImageSelected()
    {
        return imageSelected;
    }

    public String getSel()
    {
        return sel;
    }

    public String getTitle()
    {
        return title;
    }

    public void setSel(String s)
    {
        sel = s;
    }
}
