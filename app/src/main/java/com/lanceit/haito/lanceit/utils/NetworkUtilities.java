package com.lanceit.haito.lanceit.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class NetworkUtilities {
    public static void callSomeone(Activity activity,long number){
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:"+number));
        activity.startActivity(callIntent);
    }
    public static void callSomeone(Activity activity,String number){
        callSomeone(activity,Long.valueOf(number));
    }
}
