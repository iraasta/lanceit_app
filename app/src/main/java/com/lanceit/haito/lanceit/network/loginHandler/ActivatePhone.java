package com.lanceit.haito.lanceit.network.loginHandler;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.lanceit.haito.lanceit.loginActivity;
import com.lanceit.haito.lanceit.network.model.ModelJSONHandler;
import com.lanceit.haito.lanceit.refference.Connections;

import org.json.JSONObject;

public class ActivatePhone extends ModelJSONHandler {
    public ActivatePhone(Context context, RequestQueue refRequestQueue) {
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
        return null;
    }
}
