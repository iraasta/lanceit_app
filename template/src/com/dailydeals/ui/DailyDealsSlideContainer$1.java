// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import com.dailydeals.DailyDeal;

// Referenced classes of package com.dailydeals.ui:
//            DailyDealsSlideContainer

class eChangeListener extends android.support.v4.view.eListener
{

    final DailyDealsSlideContainer this$0;

    public void onPageSelected(int i)
    {
        ((DailyDeal)getActivity()).tabChanger(i + 1);
    }

    eChangeListener()
    {
        this$0 = DailyDealsSlideContainer.this;
        super();
    }
}
