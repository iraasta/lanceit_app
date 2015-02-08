// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Commons
{

    public Commons()
    {
    }

    public static long dateTimeToMillis(String s)
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            String as[] = s.split(" ");
            String as1[] = as[0].split("-");
            if (as1.length == 3)
            {
                calendar.set(Integer.parseInt(as1[0]), -1 + Integer.parseInt(as1[1]), Integer.parseInt(as1[2]));
            }
            String as2[] = as[1].split(":");
            if (as2.length == 3)
            {
                calendar.set(11, Integer.parseInt(as2[0]));
                calendar.set(12, Integer.parseInt(as2[1]));
                calendar.set(13, Integer.parseInt(as2[2]));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }

    public static long dateTimeToMillis1(String s)
    {
        Calendar calendar = Calendar.getInstance();
        try
        {
            String as[] = s.split(" ");
            String as1[] = as[0].split("-");
            if (as1.length == 3)
            {
                calendar.set(Integer.parseInt(as1[2]), -1 + Integer.parseInt(as1[0]), Integer.parseInt(as1[1]));
            }
            String as2[] = as[1].split(":");
            if (as2.length == 3)
            {
                calendar.set(11, Integer.parseInt(as2[0]));
                calendar.set(12, Integer.parseInt(as2[1]));
                calendar.set(13, Integer.parseInt(as2[2]));
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        return calendar.getTimeInMillis();
    }

    public static String getDateTime()
    {
        Date date = new Date(Calendar.getInstance().getTimeInMillis());
        return (new SimpleDateFormat("yyyy-MM-dd kk:mm:ss")).format(date);
    }

    public static boolean isBeforeToday(String s)
    {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar1 = Calendar.getInstance();
        stringToCalander(s, calendar1);
        return calendar1.compareTo(calendar) == -1;
    }

    public static boolean isBetweenToday(String s, String s1)
    {
        Calendar calendar;
        Calendar calendar2;
        int i;
        boolean flag;
        int j;
        try
        {
            calendar = Calendar.getInstance();
            Calendar calendar1 = Calendar.getInstance();
            stringToCalander(s, calendar1);
            calendar2 = Calendar.getInstance();
            stringToCalander(s1, calendar2);
            i = calendar1.compareTo(calendar);
        }
        catch (Exception exception)
        {
            return false;
        }
        flag = false;
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_61;
        }
        j = calendar2.compareTo(calendar);
        flag = false;
        if (j >= 0)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isEmpty(String s)
    {
        return s == null || s.equalsIgnoreCase("null") || s.trim().length() == 0;
    }

    public static String millsToDate(long l)
    {
        Date date = new Date(l);
        return (new SimpleDateFormat("yyyy-MM-dd")).format(date);
    }

    public static String millsToDateTime(long l)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(l);
        int i = calendar.get(5);
        int j = 1 + calendar.get(2);
        int k = calendar.get(1);
        int i1 = calendar.get(11);
        int j1 = calendar.get(12);
        StringBuilder stringbuilder = (new StringBuilder(String.valueOf(k))).append("-");
        Object obj;
        StringBuilder stringbuilder1;
        Object obj1;
        StringBuilder stringbuilder2;
        Object obj2;
        StringBuilder stringbuilder3;
        Object obj3;
        if (j < 10)
        {
            obj = (new StringBuilder("0")).append(j).toString();
        } else
        {
            obj = Integer.valueOf(j);
        }
        stringbuilder1 = stringbuilder.append(obj).append("-");
        if (i < 10)
        {
            obj1 = (new StringBuilder("0")).append(i).toString();
        } else
        {
            obj1 = Integer.valueOf(i);
        }
        stringbuilder2 = stringbuilder1.append(obj1).append(" ");
        if (i1 < 10)
        {
            obj2 = (new StringBuilder("0")).append(i1).toString();
        } else
        {
            obj2 = Integer.valueOf(i1);
        }
        stringbuilder3 = stringbuilder2.append(obj2).append(":");
        if (j1 < 10)
        {
            obj3 = (new StringBuilder("0")).append(j1).toString();
        } else
        {
            obj3 = Integer.valueOf(j1);
        }
        return stringbuilder3.append(obj3).toString();
    }

    public static double strToDouble(String s)
    {
        double d;
        try
        {
            d = Double.parseDouble(s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return 0.0D;
        }
        return d;
    }

    public static int strToInt(String s)
    {
        double d;
        try
        {
            d = strToDouble(s);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            return 0;
        }
        return (int)d;
    }

    public static long strToLong(String s)
    {
        return (long)strToDouble(s);
    }

    public static void stringToCalander(String s, Calendar calendar)
    {
        String as[] = s.split("-");
        if (as.length == 3)
        {
            calendar.set(Integer.parseInt(as[0]), -1 + Integer.parseInt(as[1]), Integer.parseInt(as[2]));
        }
    }
}
