package com.lanceit.haito.lanceit.network.telephony;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class CallListener extends PhoneStateListener {

    private boolean isPhoneCalling = false;

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch(state){
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
        }
    }

}
