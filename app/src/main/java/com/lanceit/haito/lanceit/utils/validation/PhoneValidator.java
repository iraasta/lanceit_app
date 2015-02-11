package com.lanceit.haito.lanceit.utils.validation;

import android.telephony.TelephonyManager;

public class PhoneValidator {
    TelephonyManager telephonyManager;

    public PhoneValidator(TelephonyManager telephonyManager) {
        this.telephonyManager = telephonyManager;
    }

    public boolean validate(){
        return true;
    }

    public void missCall(){

    }
}
