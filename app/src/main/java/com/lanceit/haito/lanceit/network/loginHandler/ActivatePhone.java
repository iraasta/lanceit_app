package com.lanceit.haito.lanceit.network.loginHandler;

import android.content.Context;

import com.android.volley.Response;
import com.lanceit.haito.lanceit.loginActivity;
import com.lanceit.haito.lanceit.network.model.ModelJSONHandler;
import com.lanceit.haito.lanceit.refference.Connections;

import org.json.JSONException;
import org.json.JSONObject;

public class ActivatePhone extends ModelJSONHandler {
    private String userName;
    private String phoneNumber;

    public ActivatePhone(Context context) {
        super(context, ((loginActivity) context).getRequestQueue());
        this.setUrl(Connections.URL_ACTIVATE_PHONE);
    }

    @Override
    public Response.Listener<JSONObject> setOnSuccess() {
        return null;
    }

    @Override
    public Response.ErrorListener setErrorListener() {
        return null;
    }

    @Override
    public JSONObject createRequestObject() {
        try {
            return new JSONObject()
                    .put("username", userName)
                    .put("phoneNumber",phoneNumber);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return new JSONObject();
    }

    public ActivatePhone setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public ActivatePhone setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }
}
