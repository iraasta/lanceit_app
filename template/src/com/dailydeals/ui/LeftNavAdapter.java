// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.dailydeals.model.Data;
import java.util.ArrayList;

public class LeftNavAdapter extends BaseAdapter
{

    private Context context;
    private ArrayList items;

    public LeftNavAdapter(Context context1, ArrayList arraylist)
    {
        context = context1;
        items = arraylist;
    }

    public int getCount()
    {
        return items.size();
    }

    public Data getItem(int i)
    {
        return (Data)items.get(i);
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = LayoutInflater.from(context).inflate(0x7f030005, null);
        }
        TextView textview = (TextView)view;
        Data data = (Data)items.get(i);
        textview.setText(data.getTitle());
        if (data.getSel() != null)
        {
            textview.setCompoundDrawablesWithIntrinsicBounds(data.getImageSelected(), 0, 0, 0);
            textview.setTextColor(-1);
            textview.setBackgroundColor(Color.parseColor("#727A84"));
            return view;
        } else
        {
            textview.setCompoundDrawablesWithIntrinsicBounds(data.getImage(), 0, 0, 0);
            textview.setBackgroundResource(0);
            textview.setTextColor(0xff888888);
            return view;
        }
    }
}
