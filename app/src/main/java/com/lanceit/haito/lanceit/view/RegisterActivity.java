package com.lanceit.haito.lanceit.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.network.loginHandler.RegisterHandler;
import com.lanceit.haito.lanceit.utils.validation.RegisterDataValidator;


public class RegisterActivity extends ActionBarActivity {

    private RequestQueue requestQueue;

    private EditText username;
    private EditText password;
    private EditText firstName;
    private EditText lastName;
    private EditText email;
    private EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.register_username);
        password = (EditText) findViewById(R.id.register_password);
        firstName = (EditText) findViewById(R.id.register_first);
        lastName = (EditText) findViewById(R.id.register_last);
        email = (EditText) findViewById(R.id.register_email);
        phoneNumber = (EditText) findViewById(R.id.phone_number);

        ((Button) findViewById(R.id.register_submit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (new RegisterDataValidator(RegisterActivity.this).isDataValid()){
                    new RegisterHandler(RegisterActivity.this).sendRequest();
                }
            }
        });
        phoneNumber.setText(((TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE)).getLine1Number());

        requestQueue = new Volley().newRequestQueue(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public EditText getUsername() {
        return username;
    }

    public EditText getPassword() {
        return password;
    }

    public EditText getFirstName() {
        return firstName;
    }

    public EditText getLastName() {
        return lastName;
    }

    public EditText getEmail() {
        return email;
    }

    public EditText getPhoneNumber() {
        return phoneNumber;
    }
}
