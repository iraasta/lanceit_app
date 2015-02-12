package com.lanceit.haito.lanceit.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.lanceit.haito.lanceit.R;

public class LanceDetails extends Activity {
    private static String title;
    private TextView dollerPrice;

    public LanceDetails()
    {
    }


    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.buy_screen_main);
        title = getIntent().getExtras().getString("title");
        dollerPrice = (TextView)findViewById(R.id.doller_strike);
        dollerPrice.setPaintFlags(0x10 | dollerPrice.getPaintFlags());
        getActionBar().setTitle(title);
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            finish();
        }
        return super.onOptionsItemSelected(menuitem);
    }
}
