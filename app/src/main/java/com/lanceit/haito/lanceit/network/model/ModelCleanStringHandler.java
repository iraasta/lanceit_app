package com.lanceit.haito.lanceit.network.model;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;


public abstract class ModelCleanStringHandler extends ModelJSONHandler {
    public ModelCleanStringHandler(Context context, RequestQueue refRequestQueue) {
        super(context, refRequestQueue);
    }

    @Override
    public void sendRequest(){
        Log.d("JSON", "Request leci");
        JsonObjectRequest request = new JsonObjectRequest(getMethod(), this.getUrl(), createRequestObject(),onSuccess,errorListener);
        try {
            Log.d("Request String", String.valueOf(request.getHeaders()));
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        this.getRefRequestQueue().add(request);
    }
}
