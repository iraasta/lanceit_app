package com.lanceit.haito.lanceit.utils;

import android.content.Context;

public class MyToast {
    public static void showShort(Context con, int str){
        android.widget.Toast errorToast = android.widget.Toast.makeText(con, str, android.widget.Toast.LENGTH_SHORT);
        errorToast.show();
    }public static void showShort(Context con, String str){
        android.widget.Toast errorToast = android.widget.Toast.makeText(con, str, android.widget.Toast.LENGTH_SHORT);
        errorToast.show();
    }
}
