package com.lanceit.haito.lanceit.network.telephony;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import com.lanceit.haito.lanceit.utils.PhoneUtilities;

public class CallListener extends PhoneStateListener {

    private boolean isPhoneCalling = false;
    private Context refContext;

    public CallListener(Context refContext) {
        this.refContext = refContext;
    }

    @Override
    public void onCallStateChanged(int state, String incomingNumber) {
        switch(state){
            case TelephonyManager.CALL_STATE_IDLE:
                break;
            case TelephonyManager.CALL_STATE_RINGING:
                PhoneUtilities.endCall(refContext);
                break;
            case TelephonyManager.CALL_STATE_OFFHOOK:
                break;
        }
    }

}
