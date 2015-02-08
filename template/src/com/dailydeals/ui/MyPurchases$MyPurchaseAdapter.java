// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.dailydeals.model.ItemMyPurchase;
import java.util.ArrayList;

// Referenced classes of package com.dailydeals.ui:
//            MyPurchases

private class list extends BaseAdapter
{

    private Context context;
    private LayoutInflater inflater;
    private ArrayList list;
    final MyPurchases this$0;

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
            view = inflater.inflate(0x7f030007, null);
        }
        ImageView imageview = (ImageView)view.findViewById(0x7f09002c);
        TextView textview = (TextView)view.findViewById(0x7f090009);
        TextView textview1 = (TextView)view.findViewById(0x7f09000a);
        TextView textview2 = (TextView)view.findViewById(0x7f09000c);
        TextView textview3 = (TextView)view.findViewById(0x7f09000d);
        ItemMyPurchase itemmypurchase = (ItemMyPurchase)list.get(i);
        imageview.setImageResource(itemmypurchase.getItemImage());
        textview.setText(itemmypurchase.getItemName());
        textview1.setText(itemmypurchase.getItemDate());
        textview2.setText((new StringBuilder("$")).append(itemmypurchase.getItemPrice()).toString());
        textview3.setText(itemmypurchase.getItemStatus());
        return view;
    }

    public (Context context1, ArrayList arraylist)
    {
        this$0 = MyPurchases.this;
        super();
        context = context1;
        list = arraylist;
    }
}
