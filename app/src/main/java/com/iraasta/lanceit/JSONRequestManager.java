package com.iraasta.lanceit;

import info.androidhive.listviewfeed.app.AppController;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.json.JSONObject;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.gms.internal.er;
import com.iraasta.lanceit.FeedManager.OnDone;
import com.loopj.android.http.*;




public class JSONRequestManager {

	static AsyncHttpClient client = new AsyncHttpClient();

	public JSONRequestManager() {
		// TODO Auto-generated constructor stub
	}
	public static void post(String url, JSONObject obj, final OnDone ondone)
	{
		
		// params is a JSONObject
		
		StringEntity se = null;
		try {
		    se = new StringEntity(obj.toString());
		} catch (UnsupportedEncodingException e) {
		    // handle exceptions properly!
		}
		se.setContentType(new BasicHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8"));

		client.post(null , url, se, "application/json; charset=UTF-8", new DataAsyncHttpResponseHandler() {
			
			@Override
			public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
				ondone.done();
			}
			
			@Override
			public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
				// TODO Auto-generated method stub
				
			}
		});
		
	}
	public static ResponseHandlerInterface rhi = new DataAsyncHttpResponseHandler() {
		
		@Override
		public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
			Log.v("RES SUCC", "CODE "+ String.valueOf(arg0));
			Log.v("RES SUCC", "A "+ new String(arg2));
			
		}
		
		@Override
		public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
			Log.v("RES FAIL", "A " + new String(arg2));

			
		}
	};

}
