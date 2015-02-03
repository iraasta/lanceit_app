package com.lanceit.haito.lanceit.utils;

public class CommonUtilities {
    public static boolean isDouble(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
