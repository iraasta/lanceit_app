package com.lanceit.haito.lanceit.network;

import android.content.Context;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;


public abstract class ModelJSONHandler {
    private Context refContext;
    private String url;
    private RequestQueue refRequestQueue;
    private int method = Request.Method.POST;

    public Response.ErrorListener errorListener;
    public Response.Listener<JSONObject> onSuccess;

    public ModelJSONHandler(Context context, RequestQueue refRequestQueue){
        this.refContext = context;
        this.refRequestQueue = refRequestQueue;
        this.errorListener = setErrorListener();
        this.onSuccess = setOnSuccess();
        Log.d("JSON", "Obiekt jest");
    }

    public void sendRequest(){
        Log.d("JSON","Request leci");
        JsonObjectRequest request = new JsonObjectRequest(method, this.url, createRequestObject(),onSuccess,errorListener);
        try {
            Log.d("Request String", String.valueOf(request.getHeaders()));
        } catch (AuthFailureError authFailureError) {
            authFailureError.printStackTrace();
        }
        refRequestQueue.add(request);
    }

    public abstract Response.Listener<JSONObject> setOnSuccess();
    public abstract Response.ErrorListener setErrorListener();
    public abstract JSONObject createRequestObject();

    public Context getRefContext(){
        return refContext;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }
}
