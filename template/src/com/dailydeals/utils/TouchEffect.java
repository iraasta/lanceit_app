// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import android.view.MotionEvent;
import android.view.View;

public class TouchEffect
    implements android.view.View.OnTouchListener
{

    public TouchEffect()
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        view.setAlpha(0.6F);
_L4:
        return false;
_L2:
        if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
        {
            view.setAlpha(1.0F);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
