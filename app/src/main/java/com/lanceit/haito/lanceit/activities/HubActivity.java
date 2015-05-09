package com.lanceit.haito.lanceit.activities;

import android.content.Context;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.model.User;
import com.lanceit.haito.lanceit.utils.GeoLocationManager;
import com.lanceit.haito.lanceit.view.PageTransformer;
import com.lanceit.haito.lanceit.view.hubFragments.AddFragment;
import com.lanceit.haito.lanceit.view.hubFragments.LanceListFragment;
import com.lanceit.haito.lanceit.view.hubFragments.ListAllFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class HubActivity extends ActionBarActivity implements AddFragment.OnFragmentInteractionListener, ListAllFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private User loggedUser;

    RequestQueue requestQueue;
    GeoLocationManager myLocationManager;

    ViewPager mViewPager;
    PagerTitleStrip pagerTitleStrip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        requestQueue = Volley.newRequestQueue(HubActivity.this);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Log.d("Przyszeł json",getIntent().getExtras().getString("json")+" to jest Mój JSON");
        try {
            this.loggedUser = User.parseFromJSON(new JSONObject(getIntent().getStringExtra("json")));
            Log.d("User ",this.loggedUser.getUsername() + " " + this.loggedUser.getEmail());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pager_strip);

        mViewPager.setAdapter(mSectionsPagerAdapter);

        pagerTitleStrip.setTextColor(0xFFFFFFFF);
        pagerTitleStrip.setTextSpacing(300);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        myLocationManager = new GeoLocationManager();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationManager);
        mViewPager.setPageTransformer(true, new PageTransformer());
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.register_submit) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                AddFragment addFragment = AddFragment.newInstance("Param1","Param2");
                addFragment.setParentActivity(HubActivity.this);
                return addFragment;
            } else if(position==1){
                LanceListFragment listFragment = new LanceListFragment();
                listFragment.setParentActivity(HubActivity.this);
                return listFragment;
            } else if(position==2){
                ListAllFragment listFragment = new ListAllFragment();
                listFragment.setParentActivity(HubActivity.this);
                return listFragment;
            }
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section_add).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section_listAll).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section_myList).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_hub, container, false);

            return rootView;
        }
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public GeoLocationManager getMyLocationManager() {
        return myLocationManager;
    }

    public SectionsPagerAdapter getmSectionsPagerAdapter() {
        return mSectionsPagerAdapter;
    }
}
