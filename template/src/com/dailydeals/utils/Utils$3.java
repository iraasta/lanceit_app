// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.dailydeals.utils:
//            Utils

class val.act
    implements android.content.terface.OnClickListener
{

    private final Activity val$act;
    private final String val$number;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        Intent intent = new Intent("android.intent.action.CALL");
        intent.setData(Uri.parse((new StringBuilder("tel:")).append(val$number.trim()).toString()));
        val$act.startActivity(intent);
    }

    ce()
    {
        val$number = s;
        val$act = activity;
        super();
    }
}
