// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals;

import android.content.Intent;

// Referenced classes of package com.dailydeals:
//            SplashScreen

class this._cls0 extends Thread
{

    final SplashScreen this$0;

    public void run()
    {
        sleep(1000L);
        Intent intent2 = new Intent("com.myproject.Login");
        startActivity(intent2);
        return;
        InterruptedException interruptedexception;
        interruptedexception;
        interruptedexception.printStackTrace();
        Intent intent1 = new Intent("com.myproject.Login");
        startActivity(intent1);
        return;
        Exception exception;
        exception;
        Intent intent = new Intent("com.myproject.Login");
        startActivity(intent);
        throw exception;
    }

    ()
    {
        this$0 = SplashScreen.this;
        super();
    }
}
