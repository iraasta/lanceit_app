package com.lanceit.haito.lanceit.network.lanceHandler;

import android.content.Context;
import android.util.Log;

import com.android.volley.Response;
import com.lanceit.haito.lanceit.activities.HubActivity;
import com.lanceit.haito.lanceit.network.loginHandler.ModelJSONFragmentHandler;
import com.lanceit.haito.lanceit.refference.Connections;
import com.lanceit.haito.lanceit.utils.GeoLocationManager;
import com.lanceit.haito.lanceit.view.hubFragments.AddFragment;

import org.json.JSONException;
import org.json.JSONObject;

public class AppendLance extends ModelJSONFragmentHandler {

    public AppendLance(Context context){
        super(context, ((HubActivity) context).getRequestQueue());
        this.setUrl(Connections.URL_ADD_LANCE);
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
        JSONObject request = new JSONObject();
        HubActivity refObj = (HubActivity) getRefContext();
        Log.d("Activity Checker ", refObj.toString());
        GeoLocationManager geoLocationManager = refObj.getMyLocationManager();
        AddFragment refFragment = (AddFragment) getFragment();

        Log.d("LatLng",geoLocationManager.getLat() + " " +geoLocationManager.getLng());


        try {
            request.put("title", refFragment.getTitleText().getText().toString());
            request.put("category", refFragment.getCategorySpinner().getSelectedItemId());
            request.put("description",refFragment.getDescriptionText().getText().toString());
            request.put("lat",geoLocationManager.getLat());
            request.put("lng",geoLocationManager.getLng());
            request.put("cost",Float.valueOf(refFragment.getPrice().getText().toString()));
            request.put("expireAfter",Integer.valueOf(refFragment.getExpireText().getText().toString()));

            Log.d("APPEND JSON",request.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return request;
    }
}
