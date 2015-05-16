package com.lanceit.haito.lanceit.network.lanceHandler;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.lanceit.haito.lanceit.view.hub.HubActivity;
import com.lanceit.haito.lanceit.network.model.ModelCleanStringHandler;
import com.lanceit.haito.lanceit.refference.Connections;

import org.json.JSONObject;

public class ListActiveLances extends ModelCleanStringHandler {
    public ListActiveLances(Context context, RequestQueue refRequestQueue) {
        super(context, ((HubActivity) context).getRequestQueue());
        this.setMethod(Request.Method.GET);
        this.setUrl(Connections.URL_GET_ACTIVE_LANCE);
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
        return new JSONObject();
    }
}
