// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

// Referenced classes of package com.dailydeals.ui:
//            DailyDealsContainer, DailyDealsSlideContainer

private class this._cls0 extends FragmentStatePagerAdapter
{

    final DailyDealsSlideContainer this$0;

    public int getCount()
    {
        return 3;
    }

    public Fragment getItem(int i)
    {
        return new DailyDealsContainer();
    }

    public (FragmentManager fragmentmanager)
    {
        this$0 = DailyDealsSlideContainer.this;
        super(fragmentmanager);
    }
}
