// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils
{

    public Utils()
    {
    }

    public static void changeLocale(Activity activity, Locale locale)
    {
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        activity.getBaseContext().getResources().updateConfiguration(configuration, activity.getBaseContext().getResources().getDisplayMetrics());
    }

    public static void copyFile(File file, File file1)
    {
        try
        {
            if (!file1.exists())
            {
                file1.createNewFile();
            }
            FileInputStream fileinputstream = new FileInputStream(file);
            FileOutputStream fileoutputstream = new FileOutputStream(file1);
            byte abyte0[] = new byte[(int)file.length()];
            fileinputstream.read(abyte0);
            fileoutputstream.write(abyte0);
            fileoutputstream.flush();
            fileoutputstream.close();
            fileinputstream.close();
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static void createNoMediaFile(File file)
    {
        try
        {
            File file1 = new File(file, ".nomedia");
            if (!file1.exists())
            {
                file1.createNewFile();
            }
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static final Object deSerialiseObj(byte abyte0[])
    {
        if (abyte0 == null || abyte0.length <= 0)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        Object obj;
        ObjectInputStream objectinputstream = new ObjectInputStream(new ByteArrayInputStream(abyte0));
        obj = objectinputstream.readObject();
        objectinputstream.close();
        return obj;
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public static String getBase64ImageString(String s)
    {
        if (s == null)
        {
            return null;
        }
        ByteArrayOutputStream bytearrayoutputstream;
        BufferedInputStream bufferedinputstream;
        bytearrayoutputstream = new ByteArrayOutputStream();
        bufferedinputstream = new BufferedInputStream(new FileInputStream(s));
_L1:
        int i = bufferedinputstream.read();
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        byte abyte0[] = bytearrayoutputstream.toByteArray();
        bytearrayoutputstream.flush();
        bytearrayoutputstream.close();
        bufferedinputstream.close();
        return Base64.encodeToString(abyte0, 0);
        bytearrayoutputstream.write(i);
          goto _L1
        Exception exception;
        exception;
        exception.printStackTrace();
        return null;
    }

    public static String getFormattedCount(int i)
    {
        if (i >= 0x186a0)
        {
            return "1M";
        }
        if (i >= 10000)
        {
            return "10K";
        }
        if (i >= 1000)
        {
            return "1K";
        } else
        {
            return (new StringBuilder(String.valueOf(i))).toString();
        }
    }

    public static String getMD5String(String s)
    {
        byte abyte0[];
        int i;
        StringBuilder stringbuilder;
        int j;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.reset();
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            i = abyte0.length;
            stringbuilder = new StringBuilder(i << 1);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return null;
        }
        j = 0;
        if (j < i)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        return stringbuilder.toString();
        stringbuilder.append(Character.forDigit((0xf0 & abyte0[j]) >> 4, 16));
        stringbuilder.append(Character.forDigit(0xf & abyte0[j], 16));
        j++;
        if (false)
        {
        } else
        {
            break MISSING_BLOCK_LABEL_43;
        }
    }

    public static final void hideKeyboard(Activity activity)
    {
        if (activity.getCurrentFocus() != null)
        {
            ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static final void hideKeyboard(Activity activity, View view)
    {
        try
        {
            ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    public static boolean isNumeric(String s)
    {
        return Pattern.compile("^[-+]?[0-9]*\\.?[0-9]+$", 2).matcher(s).matches();
    }

    public static final boolean isOnline(Context context)
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        return connectivitymanager.getActiveNetworkInfo() != null && connectivitymanager.getActiveNetworkInfo().isAvailable() && connectivitymanager.getActiveNetworkInfo().isConnected();
    }

    public static boolean isValidEmail(String s)
    {
        return Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,10}$", 2).matcher(s).matches();
    }

    public static boolean isValidPhoneNumber(String s)
    {
        return Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{2,15})$", 2).matcher(s).matches();
    }

    public static final void makeCall(final Activity act, final String number)
    {
        showDialog(act, (new StringBuilder("Call ")).append(number.replace(" ", "")).toString(), "Ok", "Cancel", new android.content.DialogInterface.OnClickListener() {

            private final Activity val$act;
            private final String val$number;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                Intent intent = new Intent("android.intent.action.CALL");
                intent.setData(Uri.parse((new StringBuilder("tel:")).append(number.trim()).toString()));
                act.startActivity(intent);
            }

            
            {
                number = s;
                act = activity;
                super();
            }
        }).show();
    }

    public static final byte[] serialiseObj(Serializable serializable)
    {
        byte abyte0[];
        try
        {
            ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
            ObjectOutputStream objectoutputstream = new ObjectOutputStream(bytearrayoutputstream);
            objectoutputstream.writeObject(serializable);
            abyte0 = bytearrayoutputstream.toByteArray();
            objectoutputstream.close();
            bytearrayoutputstream.close();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public static AlertDialog showDialog(Context context, int i)
    {
        return showDialog(context, context.getString(i));
    }

    public static AlertDialog showDialog(Context context, int i, int j, int k, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return showDialog(context, context.getString(i), context.getString(j), context.getString(k), onclicklistener);
    }

    public static AlertDialog showDialog(Context context, int i, int j, int k, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        return showDialog(context, context.getString(i), context.getString(j), context.getString(k), onclicklistener, onclicklistener1);
    }

    public static AlertDialog showDialog(Context context, int i, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return showDialog(context, context.getString(i), context.getString(0x104000a), ((String) (null)), onclicklistener, null);
    }

    public static AlertDialog showDialog(Context context, String s)
    {
        return showDialog(context, s, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

        });
    }

    public static AlertDialog showDialog(Context context, String s, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return showDialog(context, s, context.getString(0x104000a), ((String) (null)), onclicklistener, null);
    }

    public static AlertDialog showDialog(Context context, String s, String s1, String s2, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        return showDialog(context, s, s1, s2, onclicklistener, new android.content.DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
            }

        });
    }

    public static AlertDialog showDialog(Context context, String s, String s1, String s2, android.content.DialogInterface.OnClickListener onclicklistener, android.content.DialogInterface.OnClickListener onclicklistener1)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(s).setCancelable(false).setPositiveButton(s1, onclicklistener);
        if (s2 != null && onclicklistener1 != null)
        {
            builder.setNegativeButton(s2, onclicklistener1);
        }
        AlertDialog alertdialog = builder.create();
        alertdialog.show();
        return alertdialog;
    }

    public static void showDialog(Context context, int i, int j, android.content.DialogInterface.OnClickListener onclicklistener)
    {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context);
        builder.setMessage(j).setCancelable(false).setPositiveButton(0x104000a, onclicklistener);
        builder.setTitle(i);
        builder.create().show();
    }

    public static final void showKeyboard(Activity activity, View view)
    {
        try
        {
            view.requestFocus();
            ((InputMethodManager)activity.getSystemService("input_method")).showSoftInput(view, 1);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
