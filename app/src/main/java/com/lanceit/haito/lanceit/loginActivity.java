package com.lanceit.haito.lanceit;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.lanceit.haito.lanceit.activities.HubActivity;
import com.lanceit.haito.lanceit.activities.RegisterActivity;
import com.lanceit.haito.lanceit.network.loginHandler.LoginHandler;
import com.lanceit.haito.lanceit.refference.DataStorage;

import java.net.CookieHandler;
import java.net.CookieManager;


public class loginActivity extends Activity {

    private RequestQueue requestQueue;
    private SharedPreferences storage;

    private EditText textLogin;
    private EditText textPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

// Optionally, you can just use the default CookieManager
        CookieManager manager = new CookieManager();
        CookieHandler.setDefault(manager);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        requestQueue = new Volley().newRequestQueue(loginActivity.this);

        storage = getSharedPreferences(DataStorage.LOGIN_DATA,0);
        String logged = storage.getString(DataStorage.RECORD_LOGIN, "");

        textLogin = (EditText) findViewById(R.id.loginNick);
        textPass = (EditText) findViewById(R.id.loginPass);

        Button loginButton = (Button) findViewById(R.id.bLogin);
        Button registerButton = (Button) findViewById(R.id.bRegister);

        if(!logged.equals("")){
            textLogin.setText(logged);
            textPass.setText(storage.getString(DataStorage.RECORD_PASS,""));
            tryLogin();
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Debug",textLogin.getText()+ " " + textPass.getText());
                tryLogin();
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(loginActivity.this,RegisterActivity.class);
                startActivity(myIntent);;
            }
        });
    }


    public SharedPreferences getStorage() {
        return storage;
    }

    public RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public EditText getTextLogin(){
        return textLogin;
    }

    public EditText getTextPass(){
        return textPass;
    }

    public void tryLogin(){
        LoginHandler handler = new LoginHandler(loginActivity.this);
        handler.sendRequest();
    }

    public void loginSuccess(String extras){
        Intent myIntent = new Intent(loginActivity.this, HubActivity.class);

        Bundle bundle = new Bundle();
        bundle.putString("json",extras);

        myIntent.putExtras(bundle);
        startActivity(myIntent);

        finish();

        storage.edit().remove(DataStorage.RECORD_LOGIN).putString(DataStorage.RECORD_LOGIN,textLogin.getText().toString()).apply();
        storage.edit().remove(DataStorage.RECORD_PASS).putString(DataStorage.RECORD_PASS,textPass.getText().toString()).apply();
    }
}
