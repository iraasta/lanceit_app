package com.lanceit.haito.lanceit.network.lanceHandler;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.lanceit.haito.lanceit.network.model.ModelCleanStringHandler;

import org.json.JSONObject;

public class ListAllLancec extends ModelCleanStringHandler {
    public ListAllLancec(Context context, RequestQueue refRequestQueue) {
        super(context, refRequestQueue);
        this.setMethod(Request.Method.GET);
    }

    @Override
    public Response.Listener<JSONObject> setOnSuccess() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

            }
        };
    }

    @Override
    public Response.ErrorListener setErrorListener() {
        return null;
    }

    @Override
    public JSONObject createRequestObject() {
        return new JSONObject();
    }
}
