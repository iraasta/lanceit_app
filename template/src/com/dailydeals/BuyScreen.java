// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.dailydeals.custom.CustomActivity;

// Referenced classes of package com.dailydeals:
//            Coupon

public class BuyScreen extends CustomActivity
{

    private static String title;
    private TextView dollerPrice;

    public BuyScreen()
    {
    }

    public void onClick(View view)
    {
        super.onClick(view);
        if (view.getId() == 0x7f090007)
        {
            startActivity(new Intent(this, com/dailydeals/Coupon));
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030000);
        title = getIntent().getExtras().getString("title");
        dollerPrice = (TextView)findViewById(0x7f090005);
        dollerPrice.setPaintFlags(0x10 | dollerPrice.getPaintFlags());
        setTouchNClick(0x7f090007);
        getActionBar().setTitle(title);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
