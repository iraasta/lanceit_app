package com.lanceit.haito.lanceit.network.loginHandler;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.android.volley.RequestQueue;
import com.lanceit.haito.lanceit.network.ModelJSONHandler;


public abstract class ModelJSONFragmentHandler extends ModelJSONHandler {
    private Fragment fragment;

    public ModelJSONFragmentHandler(Context context, RequestQueue refRequestQueue) {
        super(context, refRequestQueue);
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
