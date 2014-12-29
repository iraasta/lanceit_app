package com.iraasta.lanceit.Controller;

import java.util.Calendar;

import com.iraasta.lanceit.Utilities.Managers.FeedManager;
import com.iraasta.lanceit.Utilities.Managers.FeedManager.OnDone;
import com.iraasta.lanceit.MainActivity;
import com.iraasta.lanceit.R;

import info.androidhive.listviewfeed.data.FeedItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddView {

	String[] categories = {
			"Kupno/Zakupy"
	};
	
	Button confrimButton;
	EditText titleText;
	EditText descriptionText;
	EditText expireText;
	Spinner categorySpinner;
	
	public AddView(View v) {
		categorySpinner = (Spinner)v.findViewById(R.id.category_spinner);
		confrimButton = (Button)v.findViewById(R.id.confirm_bt);
		descriptionText = (EditText)v.findViewById(R.id.description_text);
		expireText = (EditText)v.findViewById(R.id.expire_text);
		titleText = (EditText)v.findViewById(R.id.title_text);
		
		categorySpinner.setAdapter(new ArrayAdapter<String>(v.getContext(),android.R.layout.simple_spinner_dropdown_item, categories));
		
		confrimButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				if(descriptionText.length() * expireText.length() * titleText.length() == 0) return;
				Toast.makeText(MainActivity.instance, "Adding...", Toast.LENGTH_SHORT).show();
				String title = titleText.getText().toString();
				String desc = descriptionText.getText().toString();
				int expireIn = Integer.parseInt(expireText.getText().toString());
				
				FeedItem fi = new FeedItem();
				fi.setTitle(title);
				fi.setDescription(desc);
				fi.setExpiration(expireIn);
				fi.setTimeStamp(Calendar.getInstance().getTimeInMillis());
				FeedManager.sendFeed(fi, new OnDone() {

                    @Override
                    public void done() {
                        Toast.makeText(MainActivity.instance, "Finished", Toast.LENGTH_SHORT).show();
                        FeedManager.getFeed(MainActivity.mainView.onFeedDone);
                        MainActivity.instance.mViewPager.setCurrentItem(1, true);
                    }
                });
			}
		});
	}

}
