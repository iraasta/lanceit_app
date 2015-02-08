// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.dailydeals.Login;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

public class ExceptionHandler
    implements Thread.UncaughtExceptionHandler
{

    public static final String CRASH_REPORT = "crashReport";
    private final Context myContext;

    public ExceptionHandler(Context context)
    {
        myContext = context;
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        StringWriter stringwriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(stringwriter));
        System.err.println(stringwriter);
        Intent intent = new Intent(myContext, com/dailydeals/Login);
        intent.putExtra("crashReport", stringwriter.toString());
        intent.setFlags(0x4000000);
        myContext.startActivity(intent);
        Process.killProcess(Process.myPid());
        System.exit(10);
    }
}
