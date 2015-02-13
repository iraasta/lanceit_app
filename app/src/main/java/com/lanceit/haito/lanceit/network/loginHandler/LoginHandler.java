package com.lanceit.haito.lanceit.network.loginHandler;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanceit.haito.lanceit.loginActivity;
import com.lanceit.haito.lanceit.network.model.ModelJSONHandler;
import com.lanceit.haito.lanceit.refference.Connections;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginHandler extends ModelJSONHandler {

    public LoginHandler(Context context) {
        super(context, ((loginActivity) context).getRequestQueue());
        this.setUrl(Connections.URL_LOGIN);
        Log.d("JSON", "Obiekt jest");
    }

    @Override
    public Response.Listener<JSONObject> setOnSuccess() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response != null){
                    ((loginActivity) getRefContext()).loginSuccess(response.toString());
                    Log.d("thing",response.toString());
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
                    if (error.networkResponse != null && error.networkResponse.statusCode == 400) {
                        Toast errorToast = Toast.makeText(getRefContext(), "Nie udało się zalogować.", Toast.LENGTH_SHORT);
                        errorToast.show();
                    } else if(error.networkResponse != null && error.networkResponse.statusCode == 556){
                        ((loginActivity)getRefContext()).showDialog();
                    }
                }
                ((loginActivity) getRefContext()).getTextPass().setText("");
            }
        };
    }


    @Override
    public JSONObject createRequestObject() {
        loginActivity reff = (loginActivity) this.getRefContext();

        JSONObject requestData = new JSONObject();
        try {
            requestData.put("username", reff.getTextLogin().getText().toString());
            requestData.put("password", reff.getTextPass().getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.d("debug",requestData.toString());
        return requestData;
    }

}
