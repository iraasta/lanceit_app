// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.custom;

import android.support.v4.app.Fragment;
import android.view.View;

// Referenced classes of package com.dailydeals.custom:
//            CustomActivity

public class CustomFragment extends Fragment
    implements android.view.View.OnClickListener
{

    public CustomFragment()
    {
    }

    public void onClick(View view)
    {
    }

    public View setTouchNClick(View view)
    {
        view.setOnClickListener(this);
        view.setOnTouchListener(CustomActivity.TOUCH);
        return view;
    }
}
