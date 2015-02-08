// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.model;


public class ItemMyPurchase
{

    private String itemDate;
    private int itemImage;
    private String itemName;
    private String itemPrice;
    private String itemStatus;

    public ItemMyPurchase(int i, String s, String s1, String s2, String s3)
    {
        itemImage = i;
        itemName = s;
        itemDate = s1;
        itemPrice = s2;
        itemStatus = s3;
    }

    public String getItemDate()
    {
        return itemDate;
    }

    public int getItemImage()
    {
        return itemImage;
    }

    public String getItemName()
    {
        return itemName;
    }

    public String getItemPrice()
    {
        return itemPrice;
    }

    public String getItemStatus()
    {
        return itemStatus;
    }
}
