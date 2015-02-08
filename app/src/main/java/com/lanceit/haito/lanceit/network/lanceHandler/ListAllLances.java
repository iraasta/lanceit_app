package com.lanceit.haito.lanceit.network.lanceHandler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanceit.haito.lanceit.activities.HubActivity;
import com.lanceit.haito.lanceit.network.model.ModelCleanStringHandler;
import com.lanceit.haito.lanceit.refference.Connections;
import com.lanceit.haito.lanceit.view.hubFragments.ListAllFragment;

import org.json.JSONObject;

public class ListAllLances extends ModelCleanStringHandler {
    public ListAllLances(Context context) {
        super(context, ((HubActivity) context).getRequestQueue());
        this.setMethod(Request.Method.GET);
        this.setUrl(Connections.URL_GET_LANCE);
    }

    @Override
    public Response.Listener<JSONObject> setOnSuccess() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (response != null) {
                    Log.d("Response", response.toString() + " " + (getFragment() instanceof ListAllFragment));
                    if (getFragment() != null)
                        ((ListAllFragment) getFragment())
                                .getDebug()
                                .setText(response.toString());
                    else {
                        Log.d("Dupa","Nul!!");
                    }
                }
            }
        };
    }

    @Override
    public Response.ErrorListener setErrorListener() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null) {
                    Log.d("Error", error.toString());
                }
            }
        };
    }

    @Override
    public JSONObject createRequestObject() {
        return new JSONObject();
    }
}
