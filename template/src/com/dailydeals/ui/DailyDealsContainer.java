// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.dailydeals.BuyScreen;
import com.dailydeals.custom.CustomFragment;
import com.dailydeals.model.DataDeals;
import java.util.ArrayList;
import java.util.List;

public class DailyDealsContainer extends CustomFragment
{
    private class DealItemAdapter extends BaseAdapter
    {

        private Context context;
        private LayoutInflater inflater;
        private List list;
        final DailyDealsContainer this$0;

        public int getCount()
        {
            return list.size();
        }

        public Object getItem(int i)
        {
            return null;
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (view == null)
            {
                inflater = (LayoutInflater)context.getSystemService("layout_inflater");
                view = inflater.inflate(0x7f030002, null);
            }
            LinearLayout linearlayout = (LinearLayout)view.findViewById(0x7f090010);
            TextView textview = (TextView)view.findViewById(0x7f090011);
            TextView textview1 = (TextView)view.findViewById(0x7f090012);
            TextView textview2 = (TextView)view.findViewById(0x7f090009);
            TextView textview3 = (TextView)view.findViewById(0x7f09000a);
            TextView textview4 = (TextView)view.findViewById(0x7f09000d);
            DataDeals datadeals = (DataDeals)list.get(i);
            linearlayout.setBackgroundResource(datadeals.getBgMain());
            textview.setText(datadeals.getTxt1());
            textview1.setText(datadeals.getTxt2());
            textview2.setText((new StringBuilder("$")).append(datadeals.getTv1()).toString());
            textview2.setPaintFlags(0x10 | textview2.getPaintFlags());
            textview3.setText((new StringBuilder("$")).append(datadeals.getTv2()).toString());
            textview4.setText(datadeals.getTv4());
            return view;
        }

        public DealItemAdapter(Context context1, List list1)
        {
            this$0 = DailyDealsContainer.this;
            super();
            context = context1;
            list = list1;
        }
    }


    private DealItemAdapter adapter1;
    private List info;
    private ListView list;

    public DailyDealsContainer()
    {
    }

    private void launchActivity(int i, List list1)
    {
        startActivity((new Intent(getActivity().getApplicationContext(), com/dailydeals/BuyScreen)).putExtra("title", ((DataDeals)list1.get(i)).getTxt1()));
    }

    private void loadContent(View view)
    {
        list = (ListView)view.findViewById(0x7f090022);
        info = new ArrayList();
        info.add(new DataDeals(0x7f020009, getString(0x7f060016), getString(0x7f060018), "150", "100", "45"));
        info.add(new DataDeals(0x7f02000a, getString(0x7f060017), getString(0x7f060018), "2500", "1170", "15"));
        info.add(new DataDeals(0x7f020009, getString(0x7f060016), getString(0x7f060018), "150", "100", "45"));
        adapter1 = new DealItemAdapter(getActivity(), info);
        list.setAdapter(adapter1);
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final DailyDealsContainer this$0;

            public void onItemClick(AdapterView adapterview, View view1, int i, long l)
            {
                launchActivity(i, info);
            }

            
            {
                this$0 = DailyDealsContainer.this;
                super();
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        ViewGroup viewgroup1 = (ViewGroup)layoutinflater.inflate(0x7f030004, viewgroup, false);
        loadContent(viewgroup1);
        return viewgroup1;
    }


}
