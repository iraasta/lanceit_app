package com.lanceit.haito.lanceit.view.hubFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.activities.HubActivity;
import com.lanceit.haito.lanceit.activities.LanceActivity;
import com.lanceit.haito.lanceit.model.FeedItem;
import com.lanceit.haito.lanceit.model.Location;
import com.lanceit.haito.lanceit.network.lanceHandler.ListAllLances;
import com.lanceit.haito.lanceit.view.adapter.LanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class LanceListFragment extends Fragment {
    private HubActivity parentActivity;

    private LanceAdapter lanceAdapter;
    private ArrayList data;

    public LanceListFragment() {
    }

    private void launchActivity(int i, List list1) {
        startActivity(
                new Intent(getActivity().getApplicationContext(), LanceActivity.class)
                        .putExtra("data", new Gson().toJson((FeedItem) list1.get(i))));
    }

    private void loadContent(View view) {
        ListView list = (ListView) view.findViewById(R.id.list_view_feed_magic_thing_that_annoys_haito);
        data = new ArrayList<FeedItem>();

        lanceAdapter = new LanceAdapter(getActivity(), data);

        ListAllLances connection = new ListAllLances(parentActivity);
        connection.setFragment(LanceListFragment.this);
        connection.sendRequest();

        list.setAdapter(lanceAdapter);
        list.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                launchActivity(position, data);
            }
        });
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        ViewGroup viewgroup1 = (ViewGroup) layoutinflater.inflate(R.layout.deal_container, viewgroup, false);
        loadContent(viewgroup1);
        return viewgroup1;
    }

    public HubActivity getParentActivity() {
        return parentActivity;
    }

    public void setParentActivity(HubActivity parentActivity) {
        this.parentActivity = parentActivity;
    }

    public void setData(ArrayList<FeedItem> data) {
        Log.d("DataSize", data.size() + " size of feed");
        this.data.clear();

        for(FeedItem feedItem : data)
            this.data.add(feedItem);
        lanceAdapter.notifyDataSetChanged();
    }
}
