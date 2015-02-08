// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import com.dailydeals.custom.CustomActivity;

// Referenced classes of package com.dailydeals:
//            DailyDeal

public class Login extends CustomActivity
{

    private Button signup;

    public Login()
    {
    }

    public void onClick(View view)
    {
        if (view.getId() != 0x7f09002a)
        {
            startActivity(new Intent(getApplicationContext(), com/dailydeals/DailyDeal));
            finish();
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030006);
        signup = (Button)findViewById(0x7f09002a);
        setTouchNClick(0x7f090026);
        setTouchNClick(0x7f090027);
        setTouchNClick(0x7f090028);
        setTouchNClick(0x7f090029);
        setTouchNClick(0x7f09002a);
        signup.setText(Html.fromHtml((new StringBuilder(String.valueOf(getString(0x7f060007)))).append("<b>").append(getString(0x7f060008)).append("</b>").toString()));
    }
}
