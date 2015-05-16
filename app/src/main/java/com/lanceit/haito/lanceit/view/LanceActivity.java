package com.lanceit.haito.lanceit.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.model.FeedItem;

import java.lang.reflect.Type;

public class LanceActivity extends Activity {

    private FeedItem data;

    private TextView dollerPrice;
    private TextView titleTextView;

    public LanceActivity(){}

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.buy_screen_main);

        Type type = new TypeToken<FeedItem>(){}.getType();
        data = new Gson().fromJson(getIntent().getExtras().getString("data"),type);

        titleTextView = (TextView)findViewById(R.id.detail_title);
        titleTextView.setText(data.getTitle());

        dollerPrice = (TextView) findViewById(R.id.doller_strike);

        dollerPrice.setPaintFlags(0x10 | dollerPrice.getPaintFlags());

        //getActionBar().setTitle(title);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem) {
        if (menuitem.getItemId() == 0x102002c){
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
