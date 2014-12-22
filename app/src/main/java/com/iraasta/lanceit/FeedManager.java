package com.iraasta.lanceit;

import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.FeedItem;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.xml.transform.ErrorListener;
import javax.xml.transform.TransformerException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.PendingIntent.OnFinished;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;


public class FeedManager {

	private Random rand = new Random();
	public static List<FeedItem> feedItems;
	private static String URL_FEED = "http://185.49.12.175:9000/list/get";
	private static String URL_POST = "http://185.49.12.175:9000/list/add";

	private static final String TAG = MainActivity.class.getSimpleName();

	public static void getFeed( final OnDone ondone) {
		Cache cache = MainActivity.getInstance().getRequestQueue().getCache();
		final Entry entry = cache.get(URL_FEED);
		JsonObjectRequest jsonReq = new JsonObjectRequest(Method.GET, URL_FEED,
				null, new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						VolleyLog.d(TAG, "Response: " + response.toString());
						if (response != null) {
							parseJsonFeed(response);
							ondone.done();
							
						}
					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						if (entry != null)
							try {
								parseJsonFeed(new JSONObject(new String(
										entry.data, "UTF-8; charset=UTF-8")));
							} catch (UnsupportedEncodingException
									| JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						VolleyLog.d(TAG, "Error: " + error.getMessage());
					}
				});
		MainActivity.getInstance().addToRequestQueue(jsonReq);
	}

	
	private static void parseJsonFeed(JSONObject response) {
		try {
			feedItems.clear();
			JSONArray feedArray = response.getJSONArray("feeds");

			for (int i = 0; i < feedArray.length(); i++) {
				JSONObject feedObj = (JSONObject) feedArray.get(i);

				FeedItem item = new FeedItem();
				item.setId(feedObj.getJSONObject("_id").getString("$oid"));
				item.setTitle(feedObj.getString("title"));
				item.setUsername(feedObj.getString("username"));
				item.setExpiration(feedObj.getJSONObject("expireAt").getInt(
						"$date"));

				// Image might be null sometimes
				item.setDescription(feedObj.getString("description"));
				item.setTimeStamp(feedObj.getLong("timestamp"));
				item.setLatLng(feedObj.getString("lat"),
						feedObj.getString("lng"));
				// url might be null sometimes

				feedItems.add(item);
			}

			// notify data changes to list adapater
		} catch (JSONException e) {
			e.printStackTrace();
			
		}
		
	}
	public static JSONObject parseFeedJson(FeedItem fi) throws JSONException
	{
		Calendar c = Calendar.getInstance();
		JSONObject obj = new JSONObject();
		
		obj.put("username", randomString(8));
		obj.put("title", fi.getTitle());
		obj.put("description", fi.getDesription());
		obj.put("timestamp", c.getTimeInMillis());
		obj.put("lat", 0.0);
		obj.put("lng", 0.0);
		obj.put("expireAt", new JSONObject().put("$date", fi.getExpiration()) );
				
		return obj;
	}
	public static void sendFeed(FeedItem fi){
		sendFeed(fi, null);
	}
	public static void sendFeed(FeedItem fi,final OnDone ondone)
	{
		try {
			JSONRequestManager.post(URL_POST, parseFeedJson(fi), ondone);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public interface OnDone
	{
		public void done();
	}
	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	static Random rnd = new Random();

	static String randomString( int len ) 
	{
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}
	
}

