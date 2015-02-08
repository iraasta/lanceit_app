// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ImgTouchEffect
    implements android.view.View.OnTouchListener
{

    public ImgTouchEffect()
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        ImageView imageview = (ImageView)view;
        if (motionevent.getAction() == 0)
        {
            imageview.setColorFilter(Color.parseColor("#c2ebf9"), android.graphics.PorterDuff.Mode.MULTIPLY);
        } else
        if (motionevent.getAction() == 1 || motionevent.getAction() == 3)
        {
            imageview.setColorFilter(0);
            return false;
        }
        return false;
    }
}
