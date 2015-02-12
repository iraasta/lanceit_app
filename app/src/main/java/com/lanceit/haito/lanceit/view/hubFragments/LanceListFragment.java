package com.lanceit.haito.lanceit.view.hubFragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.model.FeedItem;
import com.lanceit.haito.lanceit.view.LanceDetails;
import com.lanceit.haito.lanceit.view.adapter.LanceAdapter;

import java.util.ArrayList;
import java.util.List;

public class LanceListFragment extends Fragment {
    private LanceAdapter adapter1;
    private ArrayList data;
    private ListView list;

    public LanceListFragment() {
    }

    private void launchActivity(int i, List list1) {
        startActivity(
                new Intent(getActivity().getApplicationContext(), LanceDetails.class)
                        .putExtra("title", ((FeedItem) list1.get(i)).getTitile()));
    }

    private void loadContent(View view) {
        list = (ListView) view.findViewById(R.id.list_view_feed_magic_thing_that_annoys_haito);
        data = new ArrayList();
        adapter1 = new LanceAdapter(getActivity(), data);
        list.setAdapter(adapter1);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle) {
        ViewGroup viewgroup1 = (ViewGroup) layoutinflater.inflate(R.layout.deal_container, viewgroup, false);
        loadContent(viewgroup1);
        return viewgroup1;
    }
}
