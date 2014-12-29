package info.androidhive.listviewfeed.adapter;

import info.androidhive.listviewfeed.app.AppController;
import info.androidhive.listviewfeed.data.FeedItem;

import java.util.List;
import java.util.Random;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.format.DateUtils;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.iraasta.lanceit.MainActivity;
import com.iraasta.lanceit.R;
import com.iraasta.lanceit.Utilities.Managers.GeoLocationManager;

public class FeedListAdapter extends BaseAdapter {	
	private Activity activity;
	private LayoutInflater inflater;
	private List<FeedItem> feedItems;
    private GeoLocationManager myLocation;
	private Random rand;
    private final TextPaint mPaint = new TextPaint();


	public FeedListAdapter(Activity activity, List<FeedItem> feedItems) {
		this.activity = activity;
		this.feedItems = feedItems;
        setMyLocation();
	}

	@Override
	public int getCount() {
		return feedItems.size();
	}

	@Override
	public Object getItem(int location) {
		return feedItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.feed_item, null);


		TextView name = (TextView) convertView.findViewById(R.id.name);
		TextView timestamp = (TextView) convertView
				.findViewById(R.id.timestamp);
		TextView statusMsg = (TextView) convertView
				.findViewById(R.id.txtStatusMsg);
		TextView profilePic = (TextView) convertView
				.findViewById(R.id.profilePic);

		FeedItem item = feedItems.get(position);

		name.setText(item.getTitle());

		// Converting timestamp into x ago format
		CharSequence timeAgo = DateUtils.getRelativeTimeSpanString(
				item.getTimeStamp(),
				System.currentTimeMillis(), DateUtils.SECOND_IN_MILLIS);
		timestamp.setText(String.valueOf(Math.round(myLocation.getDistanceFrom(item.getLat(), item.getLng()))*1000) + "m");

		// Chcek for empty status message
		if (!TextUtils.isEmpty(item.getDesription())) {
			statusMsg.setText(item.getDesription());
			statusMsg.setVisibility(View.VISIBLE);
		} else {
			// status is empty, remove from view
			statusMsg.setVisibility(View.GONE);
		}


		// user profile pic
		// Get random color
		char letter = item.getUsername().charAt(0);
		profilePic.setBackgroundColor(getColor(letter));
		profilePic.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));
		profilePic.setTextColor(Color.WHITE);
		profilePic.setText(String.valueOf(letter));
		profilePic.setTextSize(45);
		profilePic.setGravity(Gravity.CENTER);
		profilePic.setPadding(0, -20, 0, 0);
		//profilePic.setA(true);

		

		return convertView;
	}
	int getColor(char letter)
	{
		TypedArray myArray = MainActivity.instance.getResources().obtainTypedArray(R.array.letter_tile_colors);
		int color = myArray.getColor((int)letter % (myArray.length()-1) , 0 );
		myArray.recycle();
		return color;
	}

    public void setMyLocation() {
        this.myLocation = MainActivity.getGeoLocationManager();
    }
}
