package com.lanceit.haito.lanceit.utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanceit.haito.lanceit.model.FeedItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class SerializationHelper {

    public static JSONArray flattenStupidWendeId(JSONArray array){
        for(int n = 0; n < array.length(); n++){
            try {
                //TODO: Wpierdol wendemu niech zmapuje to porzadnie na serwie
                //TODO: Zrobic to porzadnie, moze jakies generic funkcje?
                JSONObject object = array.getJSONObject(n);

                //Flattening id
                JSONObject holder = object.getJSONObject("id");
                String temp = holder.getString("$oid");
                object.remove("id");
                object.put("id", temp);
                Log.d("ID", holder.toString());
                Log.d("actual id", temp);

                holder = object.getJSONObject("createdAt");
                temp = holder.getString("$date");
                object.remove("createdAt");
                object.put("createdAt",temp);

                holder = object.getJSONObject("expireAt");
                temp = holder.getString("$date");
                object.remove("expireAt");
                object.put("expireAt",temp);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            // do some stuff....
        }

        return array;
    }

    //TODO: Cos w ten desen?
    public static <T> void flatten(JSONObject target, String select){
        try {
            T temp = (T) target.get(select);
            target.remove(select);
            target.put(select,temp);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<FeedItem> parseFeed(String toParse){
        Type collectionType = new TypeToken<ArrayList<FeedItem>>(){}.getType();
        ArrayList<FeedItem> outcome = new Gson().fromJson(toParse, collectionType);
        return outcome;
    }

}
