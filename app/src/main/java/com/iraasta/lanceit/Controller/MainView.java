package com.iraasta.lanceit.Controller;

import info.androidhive.listviewfeed.adapter.FeedListAdapter;
import info.androidhive.listviewfeed.data.FeedItem;

import java.util.ArrayList;

import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import com.iraasta.lanceit.Utilities.Managers.FeedManager;
import com.iraasta.lanceit.Utilities.Managers.FeedManager.OnDone;
import com.iraasta.lanceit.MainActivity;
import com.iraasta.lanceit.R;

import de.timroes.swipetodismiss.SwipeDismissList;
import de.timroes.swipetodismiss.SwipeDismissList.UndoMode;
import de.timroes.swipetodismiss.SwipeDismissList.Undoable;

public class MainView {
	private ListView listView;
	private FeedListAdapter listAdapter;
	private EnhancedSwipeRefreshLayout swipeLayout;
	public OnDone onFeedDone;

	
	public MainView(View v) {
		listView = (ListView) v.findViewById(R.id.list);

		
		
		SwipeDismissList.OnDismissCallback callback = new SwipeDismissList.OnDismissCallback() {
			
			@Override
			public Undoable onDismiss(AbsListView listView, final int position) {
				// TODO Auto-generated method stub
				final FeedItem fi = FeedManager.feedItems.get(position);
				FeedManager.feedItems.remove(position);
				listAdapter.notifyDataSetChanged();
				return new SwipeDismissList.Undoable() {
		            public void undo() {
		                // Return the item at its previous position again
		            	FeedManager.feedItems.add(position, fi);
		            	listAdapter.notifyDataSetChanged();
		            }
		        };
			}
		};
		UndoMode mode = UndoMode.MULTI_UNDO;
		SwipeDismissList swipeDismissList = new SwipeDismissList(listView, callback, mode);
		swipeDismissList.setAutoHideDelay(3000);
		swipeDismissList.setRequireTouchBeforeDismiss(false);
		
		FeedManager.feedItems = new ArrayList<FeedItem>();

		listAdapter = new FeedListAdapter(MainActivity.instance, FeedManager.feedItems);
		listView.setAdapter(listAdapter);
		
		onFeedDone = new FeedManager.OnDone() {
			
			@Override
			public void done() {
				swipeLayout.setRefreshing(false);
				listAdapter.notifyDataSetChanged();
				
			}
		};
		
		FeedManager.getFeed(onFeedDone);
	
		swipeLayout = (EnhancedSwipeRefreshLayout) v.findViewById(R.id.swipe_container);
	    swipeLayout.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				Toast.makeText(MainActivity.instance, "Refreshing", Toast.LENGTH_SHORT).show();
				FeedManager.getFeed(onFeedDone);
				
			}
		});
	    swipeLayout.setEnhancedListViewChild(swipeDismissList);
	    swipeLayout.setColorScheme(
	    		R.color.top, 
	            R.color.middle_top, 
	            R.color.middle_bot,
	            R.color.bot);	
	}
	
	
	public class GetData extends AsyncTask<Void, Void, Void> {
	    @Override
	    protected void onPreExecute() {
	        super.onPreExecute();

	    }

	    @Override
	    protected Void doInBackground(Void... params) {

	    	//FeedManager.getFeed();
	        return null;
	    }

	    @Override
	    protected void onPostExecute(Void result) {
	        super.onPostExecute(result);
	        Toast.makeText(MainActivity.instance, "Feed refreshed", Toast.LENGTH_SHORT).show();
	        swipeLayout.setRefreshing(false);
	    }

	}

}

