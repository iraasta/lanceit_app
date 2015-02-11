package com.lanceit.haito.lanceit.activities.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import com.lanceit.haito.lanceit.R;

public class PhoneActivationDialog extends AlertDialog {

    public Activity refActivity;

    public PhoneActivationDialog(Context context) {
        super(context);
        this.refActivity = (Activity) context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(refActivity);
        // Get the layout inflater
        LayoutInflater inflater = refActivity.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.phone_activation, null))
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        Log.d("Lol","działa....");
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        PhoneActivationDialog.this.cancel();
                    }
                });
    }
}
