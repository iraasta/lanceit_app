package com.lanceit.haito.lanceit.network.telephony;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.lanceit.haito.lanceit.network.loginHandler.ActivatePhone;
import com.lanceit.haito.lanceit.utils.PhoneUtilities;

public class ActivationCallListener extends PhoneStateListener {

    private boolean isPhoneCalling = false;
    private Context refContext;
    private String numberToCheck;
    private String username;

    public ActivationCallListener(Context refContext, String numberToCheck, String username) {
        this.refContext = refContext;
        this.numberToCheck = numberToCheck;
        this.username = username;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch (state) {
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                if (numberToCheck.equals(incomingNumber)) {
                    PhoneUtilities.endCall(refContext);
                    new ActivatePhone(refContext)
                            .setUserName(username)
                            .setPhoneNumber(incomingNumber)
                            .sendRequest();
                } else
                    Log.d("PhoneActivationDebug", " Numer jest niepoprawny");
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
        }
    }

}
