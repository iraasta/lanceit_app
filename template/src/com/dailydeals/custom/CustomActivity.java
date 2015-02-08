// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.custom;

import android.app.ActionBar;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.dailydeals.utils.TouchEffect;

public class CustomActivity extends FragmentActivity
    implements android.view.View.OnClickListener
{

    public static final TouchEffect TOUCH = new TouchEffect();

    public CustomActivity()
    {
    }

    public void onClick(View view)
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setupActionBar();
    }

    public View setClick(int i)
    {
        View view = findViewById(i);
        if (view != null)
        {
            view.setOnClickListener(this);
        }
        return view;
    }

    public View setTouchNClick(int i)
    {
        View view = setClick(i);
        if (view != null)
        {
            view.setOnTouchListener(TOUCH);
        }
        return view;
    }

    protected void setupActionBar()
    {
        ActionBar actionbar = getActionBar();
        if (actionbar == null)
        {
            return;
        } else
        {
            actionbar.setDisplayShowTitleEnabled(true);
            actionbar.setNavigationMode(0);
            actionbar.setDisplayUseLogoEnabled(false);
            actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f020034));
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeButtonEnabled(true);
            return;
        }
    }

}
