package com.lanceit.haito.lanceit.view.drawer.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.view.drawer.model.DrawerItem;

import java.util.ArrayList;

public class DrawerListAdapter extends BaseAdapter{

    private Context context;
    private ArrayList<DrawerItem> drawerItems;

    public DrawerListAdapter(Context applicationContext, ArrayList<DrawerItem> navDrawerItems) {
        this.context = applicationContext;
        this.drawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return drawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return drawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.drawer_list_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        imgIcon.setImageResource(drawerItems.get(position).getIcon());
        txtTitle.setText(drawerItems.get(position).getTitle());

        // displaying count
        // check whether it set visible or not
        if(drawerItems.get(position).isCounterVisible()){
            txtCount.setText(drawerItems.get(position).getCount());
        }else{
            txtCount.setVisibility(View.GONE);
        }

        return convertView;
    }
}
