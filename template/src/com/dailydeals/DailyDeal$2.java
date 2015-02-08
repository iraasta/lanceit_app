// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals;

import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import com.dailydeals.model.Data;
import com.dailydeals.ui.LeftNavAdapter;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.dailydeals:
//            DailyDeal

class val.al
    implements android.widget.OnItemClickListener
{

    final DailyDeal this$0;
    private final ArrayList val$al;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        DailyDeal.access$1(DailyDeal.this).closeDrawers();
        DailyDeal.access$2(DailyDeal.this).setVisibility(8);
        Iterator iterator = val$al.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                ((Data)val$al.get(i)).setSel("");
                DailyDeal.access$3(DailyDeal.this).notifyDataSetChanged();
                DailyDeal.access$4(DailyDeal.this, i);
                return;
            }
            ((Data)iterator.next()).setSel(null);
        } while (true);
    }

    apter()
    {
        this$0 = final_dailydeal;
        val$al = ArrayList.this;
        super();
    }
}
