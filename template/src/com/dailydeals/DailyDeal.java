// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dailydeals;

import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.dailydeals.custom.CustomActivity;
import com.dailydeals.model.Data;
import com.dailydeals.ui.DailyDealsSlideContainer;
import com.dailydeals.ui.LeftNavAdapter;
import com.dailydeals.ui.MyProfile;
import com.dailydeals.ui.MyPurchases;
import java.util.ArrayList;
import java.util.Iterator;

public class DailyDeal extends CustomActivity
{

    public static int pos;
    private LeftNavAdapter adapter;
    private DailyDealsSlideContainer cont;
    private DrawerLayout drawerLayout;
    private View drawerLeft;
    private ActionBarDrawerToggle drawerToggle;
    private Button tab1;
    private Button tab2;
    private Button tab3;
    private LinearLayout tabBar;
    private View tabStrip1;
    private View tabStrip2;
    private View tabStrip3;

    public DailyDeal()
    {
    }

    private ArrayList getDummyLeftNavItems()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new Data(getString(0x7f060024), 0x7f020021, 0x7f020022));
        arraylist.add(new Data("My Purchases", 0x7f020023, 0x7f020024));
        return arraylist;
    }

    private void openPage(int i)
    {
        Object obj;
        String s;
        obj = null;
        s = null;
        i;
        JVM INSTR tableswitch 0 2: default 32
    //                   0 69
    //                   1 83
    //                   2 97;
           goto _L1 _L2 _L3 _L4
_L1:
        if (obj == null) goto _L6; else goto _L5
_L5:
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) goto _L8; else goto _L7
_L7:
        if (i != 2)
        {
            break; /* Loop/switch isn't completed */
        }
        getSupportFragmentManager().beginTransaction().replace(0x7f09001c, ((android.support.v4.app.Fragment) (obj))).commit();
_L6:
        return;
_L2:
        obj = new MyProfile();
        s = "Profile";
        continue; /* Loop/switch isn't completed */
_L3:
        obj = new MyPurchases();
        s = "My Purchases";
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new DailyDealsSlideContainer();
        s = getString(0x7f060002);
        continue; /* Loop/switch isn't completed */
_L8:
        getSupportFragmentManager().popBackStackImmediate();
        if (true) goto _L5; else goto _L9
_L9:
        getSupportFragmentManager().beginTransaction().replace(0x7f09001c, ((android.support.v4.app.Fragment) (obj))).addToBackStack(s).commit();
        return;
        if (true) goto _L1; else goto _L10
_L10:
    }

    private void setActionBar()
    {
        ActionBar actionbar = getActionBar();
        actionbar.setNavigationMode(0);
        actionbar.setBackgroundDrawable(getResources().getDrawable(0x7f020034));
        actionbar.setDisplayShowHomeEnabled(false);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeButtonEnabled(true);
        actionbar.setDisplayUseLogoEnabled(false);
        actionbar.setTitle(0x7f060002);
    }

    private void setActionBarTitle()
    {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0)
        {
            getActionBar().setTitle(0x7f060002);
            return;
        }
        String s = getSupportFragmentManager().getBackStackEntryAt(-1 + getSupportFragmentManager().getBackStackEntryCount()).getName();
        ActionBar actionbar = getActionBar();
        if (s == null)
        {
            s = getString(0x7f060002);
        }
        actionbar.setTitle(s);
    }

    private void setupContainer()
    {
        getSupportFragmentManager().addOnBackStackChangedListener(new android.support.v4.app.FragmentManager.OnBackStackChangedListener() {

            final DailyDeal this$0;

            public void onBackStackChanged()
            {
                setActionBarTitle();
            }

            
            {
                this$0 = DailyDeal.this;
                super();
            }
        });
        tabBar.setVisibility(0);
        openPage(2);
    }

    private void setupDrawer()
    {
        drawerLayout = (DrawerLayout)findViewById(0x7f090013);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, 0x7f02000c, 0x7f060000, 0x7f060001) {

            final DailyDeal this$0;

            public void onDrawerClosed(View view)
            {
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View view)
            {
                setActionBarTitle();
            }

            
            {
                this$0 = DailyDeal.this;
                super(activity, drawerlayout, i, j, k);
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
        drawerLayout.closeDrawers();
        setupLeftNavDrawer();
    }

    private void setupLeftNavDrawer()
    {
        ListView listview = (ListView)findViewById(0x7f090020);
        final ArrayList al = getDummyLeftNavItems();
        adapter = new LeftNavAdapter(this, al);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final DailyDeal this$0;
            private final ArrayList val$al;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                drawerLayout.closeDrawers();
                tabBar.setVisibility(8);
                Iterator iterator = al.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        ((Data)al.get(i)).setSel("");
                        adapter.notifyDataSetChanged();
                        openPage(i);
                        return;
                    }
                    ((Data)iterator.next()).setSel(null);
                } while (true);
            }

            
            {
                this$0 = DailyDeal.this;
                al = arraylist;
                super();
            }
        });
    }

    public void onClick(View view)
    {
        super.onClick(view);
        if (view.getId() == 0x7f090016)
        {
            pos = 0;
            setupContainer();
            tabChanger(1);
        }
        if (view.getId() == 0x7f090018)
        {
            pos = 1;
            setupContainer();
            tabChanger(2);
        }
        if (view.getId() == 0x7f09001a)
        {
            pos = 2;
            setupContainer();
            tabChanger(3);
        }
        if (view.getId() == 0x7f090021)
        {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        drawerToggle.onConfigurationChanged(configuration);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030003);
        drawerLeft = findViewById(0x7f09001d);
        tabBar = (LinearLayout)findViewById(0x7f090015);
        tabStrip1 = findViewById(0x7f090017);
        tabStrip2 = findViewById(0x7f090019);
        tabStrip3 = findViewById(0x7f09001b);
        tab1 = (Button)findViewById(0x7f090016);
        tab2 = (Button)findViewById(0x7f090018);
        tab3 = (Button)findViewById(0x7f09001a);
        setTouchNClick(0x7f090016);
        setTouchNClick(0x7f090018);
        setTouchNClick(0x7f09001a);
        tabStrip1.setBackgroundColor(Color.parseColor("#FFFF8D"));
        tab2.setTextColor(Color.parseColor("#FFC9C3"));
        tab3.setTextColor(Color.parseColor("#FFC9C3"));
        setupContainer();
        setActionBar();
        setupDrawer();
        setTouchNClick(0x7f090021);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f080001, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            drawerLayout.closeDrawers();
            setupLeftNavDrawer();
            if (getSupportFragmentManager().getBackStackEntryCount() > 0)
            {
                getSupportFragmentManager().popBackStackImmediate();
                setupContainer();
            } else
            {
                finish();
            }
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (drawerToggle.onOptionsItemSelected(menuitem))
        {
            return true;
        } else
        {
            return super.onOptionsItemSelected(menuitem);
        }
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        drawerToggle.syncState();
    }

    protected void onResume()
    {
        super.onResume();
        tabBar.setVisibility(0);
    }

    public void tabChanger(int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            tabStrip1.setBackgroundColor(Color.parseColor("#FFFF8D"));
            tabStrip2.setBackgroundColor(Color.parseColor("#FF5E47"));
            tabStrip3.setBackgroundColor(Color.parseColor("#FF5E47"));
            tab1.setTextColor(-1);
            tab2.setTextColor(Color.parseColor("#FFC9C3"));
            tab3.setTextColor(Color.parseColor("#FFC9C3"));
            return;

        case 2: // '\002'
            tabStrip1.setBackgroundColor(Color.parseColor("#FF5E47"));
            tabStrip2.setBackgroundColor(Color.parseColor("#FFFF8D"));
            tabStrip3.setBackgroundColor(Color.parseColor("#FF5E47"));
            tab1.setTextColor(Color.parseColor("#FFC9C3"));
            tab2.setTextColor(-1);
            tab3.setTextColor(Color.parseColor("#FFC9C3"));
            return;

        case 3: // '\003'
            tabStrip1.setBackgroundColor(Color.parseColor("#FF5E47"));
            break;
        }
        tabStrip2.setBackgroundColor(Color.parseColor("#FF5E47"));
        tabStrip3.setBackgroundColor(Color.parseColor("#FFFF8D"));
        tab1.setTextColor(Color.parseColor("#FFC9C3"));
        tab2.setTextColor(Color.parseColor("#FFC9C3"));
        tab3.setTextColor(-1);
    }





}
