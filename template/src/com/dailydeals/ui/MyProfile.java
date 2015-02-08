// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import com.dailydeals.custom.CustomFragment;

public class MyProfile extends CustomFragment
{

    private CheckBox notification;

    public MyProfile()
    {
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        super.onCreateOptionsMenu(menu, menuinflater);
        menu.clear();
        menuinflater.inflate(0x7f080000, menu);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f030009, null);
        notification = (CheckBox)view.findViewById(0x7f090032);
        notification.setChecked(true);
        setTouchNClick(view.findViewById(0x7f090031));
        setHasOptionsMenu(true);
        return view;
    }
}
