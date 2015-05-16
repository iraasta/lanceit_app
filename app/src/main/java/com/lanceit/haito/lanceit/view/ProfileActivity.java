package com.lanceit.haito.lanceit.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.model.User;

public class ProfileActivity extends ActionBarActivity {

    private User loggedUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        getSupportActionBar().setHomeButtonEnabled(true);

        Log.d("JsonUserData", getIntent().getExtras().getString("user"));
        loggedUser = new Gson().fromJson(getIntent().getExtras().getString("user"),
                new TypeToken<User>() {}.getType());

        ((TextView)findViewById(R.id.profile_name)).setText(loggedUser.getUsername());
        ((TextView)findViewById(R.id.profile_email)).setText(loggedUser.getEmail());

        ((EditText)findViewById(R.id.profile_edit_name)).setHint(loggedUser.getFirstName());
        ((EditText)findViewById(R.id.profile_second_name)).setHint(loggedUser.getLastName());
        ((EditText)findViewById(R.id.profile_edit_email)).setHint(loggedUser.getEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_search, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
