package com.lanceit.haito.lanceit.network.loginHandler;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.lanceit.haito.lanceit.activities.RegisterActivity;
import com.lanceit.haito.lanceit.network.model.ModelJSONHandler;
import com.lanceit.haito.lanceit.refference.Connections;
import com.lanceit.haito.lanceit.utils.MyToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RegisterHandler extends ModelJSONHandler {

    public RegisterHandler(Context context){
        super(context, ((RegisterActivity) context).getRequestQueue());
        this.setUrl(Connections.URL_REGISTER);
    }

    @Override
    public Response.Listener<JSONObject> setOnSuccess() {
        return new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(response != null){
                    try {
                        if(response.get("success") == "true"){
                            MyToast.showShort(getRefContext(),"Rejstracja powiodła się możesz się zalogować");
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
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
                if(error != null){
                    Log.d("debug", error.toString());
                }
            }
        };
    }

    @Override
    public JSONObject createRequestObject() {
        JSONObject jsonObject = new JSONObject();
        RegisterActivity ref = (RegisterActivity) getRefContext();

        TelephonyManager holder = (TelephonyManager)ref.getSystemService(Context.TELEPHONY_SERVICE);

        try {
            jsonObject.put("username",ref.getUsername().getText());
            jsonObject.put("firstName",ref.getFirstName().getText());
            jsonObject.put("lastName",ref.getLastName().getText());
            jsonObject.put("email",ref.getEmail().getText());
            jsonObject.put("password",ref.getPassword().getText());
            jsonObject.put("shareholders", new JSONArray());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.d("Network","Sending " + jsonObject);

        return jsonObject;
    }
}
