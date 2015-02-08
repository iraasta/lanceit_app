// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.dailydeals.DailyDeal;
import com.dailydeals.custom.CustomFragment;

// Referenced classes of package com.dailydeals.ui:
//            ZoomOutPageTransformer, DailyDealsContainer

public class DailyDealsSlideContainer extends CustomFragment
{
    private class SlideAdapter extends FragmentStatePagerAdapter
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

        public SlideAdapter(FragmentManager fragmentmanager)
        {
            this$0 = DailyDealsSlideContainer.this;
            super(fragmentmanager);
        }
    }


    private static final int NUM_PAGES = 3;
    private SlideAdapter adapter;
    private ViewPager pager;

    public DailyDealsSlideContainer()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        View view = layoutinflater.inflate(0x7f03000a, null);
        pager = (ViewPager)view.findViewById(0x7f090034);
        adapter = new SlideAdapter(getFragmentManager());
        pager.setAdapter(adapter);
        pager.setCurrentItem(DailyDeal.pos, true);
        pager.setPageTransformer(true, new ZoomOutPageTransformer());
        pager.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            final DailyDealsSlideContainer this$0;

            public void onPageSelected(int i)
            {
                ((DailyDeal)getActivity()).tabChanger(i + 1);
            }

            
            {
                this$0 = DailyDealsSlideContainer.this;
                super();
            }
        });
        return view;
    }
}
