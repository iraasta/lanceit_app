package com.lanceit.haito.lanceit.view.hub;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.loginActivity;
import com.lanceit.haito.lanceit.model.User;
import com.lanceit.haito.lanceit.utils.GeoLocationManager;
import com.lanceit.haito.lanceit.view.ProfileActivity;
import com.lanceit.haito.lanceit.view.drawer.adapter.DrawerListAdapter;
import com.lanceit.haito.lanceit.view.drawer.model.DrawerItem;
import com.lanceit.haito.lanceit.view.hub.hubFragments.AddFragment;
import com.lanceit.haito.lanceit.view.hub.hubFragments.LanceListFragment;
import com.lanceit.haito.lanceit.view.hub.hubFragments.ListAllFragment;

import java.util.ArrayList;
import java.util.Locale;

public class HubActivity extends ActionBarActivity implements AddFragment.OnFragmentInteractionListener, ListAllFragment.OnFragmentInteractionListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private User loggedUser;

    private RequestQueue requestQueue;
    private GeoLocationManager myLocationManager;

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private RelativeLayout mDrawerPane;
    private ActionBarDrawerToggle mDrawerToggle;

    // nav drawer title
    private CharSequence mDrawerTitle;

    // used to store app title
    private CharSequence mTitle;

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub);

        requestQueue = Volley.newRequestQueue(HubActivity.this);

        this.loggedUser = new Gson().fromJson(getIntent().getExtras().getString("user"),
                new TypeToken<User>() {}.getType());

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setCurrentItem(1);

        PagerTitleStrip pagerTitleStrip = (PagerTitleStrip) findViewById(R.id.pager_strip);
        pagerTitleStrip.setTextColor(0xFFFFFFFF);
        pagerTitleStrip.setTextSpacing(300);

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        myLocationManager = new GeoLocationManager();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, myLocationManager);

        mViewPager.setPageTransformer(true, new PageTransformer());

        /* -------- To be debuged */
        mTitle = mDrawerTitle = getTitle();

        // load slide menu items
        String[] navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        // nav drawer icons from resources
        TypedArray navMenuIcons = getResources()
                .obtainTypedArray(R.array.nav_drawer_icons);

        mDrawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

        ArrayList<DrawerItem> navDrawerItems = populateList(navMenuTitles, navMenuIcons);

        // Recycle the typed array
        navMenuIcons.recycle();

        // setting the nav drawer list adapter
        DrawerListAdapter adapter = new DrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);

        // enabling action bar app icon and behaving it as toggle button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        findViewById(R.id.profileBox).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(HubActivity.this, ProfileActivity.class);
                next.putExtra("user", new Gson().toJson(loggedUser));
                startActivity(next);
            }
        });

        findViewById(R.id.logout_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(HubActivity.this, loginActivity.class);
                startActivity(next);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // toggle nav drawer on selecting action bar app icon/title
        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle action bar actions click
        switch (item.getItemId()) {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggls
        mDrawerToggle.onConfigurationChanged(newConfig);
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
            if (position == 0) {
                AddFragment addFragment = AddFragment.newInstance("Param1", "Param2");
                addFragment.setParentActivity(HubActivity.this);
                return addFragment;
            } else if (position == 1) {
                LanceListFragment listFragment = new LanceListFragment();
                listFragment.setParentActivity(HubActivity.this);
                return listFragment;
            }
            ListAllFragment listFragment = new ListAllFragment();
            listFragment.setParentActivity(HubActivity.this);
            return listFragment;

        }

        @Override
        public int getCount() {
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

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public GeoLocationManager getMyLocationManager() {
        return myLocationManager;
    }

    public SectionsPagerAdapter getmSectionsPagerAdapter() {
        return mSectionsPagerAdapter;
    }

    private ArrayList<DrawerItem> populateList(String[] navMenuTitles, TypedArray navMenuIcons) {
        ArrayList<DrawerItem> navDrawerItems = new ArrayList<>();

        navDrawerItems.add(new DrawerItem(navMenuTitles[0], navMenuIcons.getResourceId(0, -1)));
        navDrawerItems.add(new DrawerItem(navMenuTitles[1], navMenuIcons.getResourceId(1, -1)));
        navDrawerItems.add(new DrawerItem(navMenuTitles[2], navMenuIcons.getResourceId(2, -1)));
        navDrawerItems.add(new DrawerItem(navMenuTitles[3], navMenuIcons.getResourceId(3, -1), true, "22"));
        navDrawerItems.add(new DrawerItem(navMenuTitles[4], navMenuIcons.getResourceId(4, -1)));
        navDrawerItems.add(new DrawerItem(navMenuTitles[5], navMenuIcons.getResourceId(5, -1), true, "50+"));

        return navDrawerItems;
    }
}
