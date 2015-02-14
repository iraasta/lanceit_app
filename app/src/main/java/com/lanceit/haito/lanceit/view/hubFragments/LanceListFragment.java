package com.lanceit.haito.lanceit.view.hubFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.activities.HubActivity;
import com.lanceit.haito.lanceit.activities.LanceActivity;
import com.lanceit.haito.lanceit.model.FeedItem;
import com.lanceit.haito.lanceit.view.adapter.LanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class LanceListFragment extends Fragment {
    private HubActivity parentActivity;

    private LanceAdapter adapter1;
    private ArrayList data;
    private ListView list;

    public LanceListFragment() {
    }

    private void launchActivity(int i, List list1) {
        startActivity(
                new Intent(getActivity().getApplicationContext(), LanceActivity.class)
                        .putExtra("title", ((FeedItem) list1.get(i)).getTitile()));
    }

    private void loadContent(View view) {
        list = (ListView) view.findViewById(R.id.list_view_feed_magic_thing_that_annoys_haito);
        data = new ArrayList();
        adapter1 = new LanceAdapter(getActivity(), data);
        adapter1.list.add(new FeedItem("12312","Title","Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description ","13216654","123654987",123,233,1,1));
        adapter1.list.add(new FeedItem("12312","Title","Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description ","13216654","123654987",123,443,1,1));
        adapter1.list.add(new FeedItem("12312","Title","Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description ","13216654","123654987",123,23,1,1));
        adapter1.list.add(new FeedItem("12312","Title","Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description Description ","13216654","123654987",123,144,1,1));
        list.setAdapter(adapter1);
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

}
