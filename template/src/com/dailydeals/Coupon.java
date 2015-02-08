// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals;

import android.os.Bundle;
import android.view.View;
import com.dailydeals.custom.CustomActivity;

public class Coupon extends CustomActivity
{

    public Coupon()
    {
    }

    public void onClick(View view)
    {
        super.onClick(view);
        if (view.getId() == 0x7f09000f)
        {
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030001);
        setTouchNClick(0x7f09000f);
    }
}
