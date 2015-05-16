package com.lanceit.haito.lanceit.utils.validation;

import android.content.Context;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.view.RegisterActivity;
import com.lanceit.haito.lanceit.refference.Validation;
import com.lanceit.haito.lanceit.utils.MyToast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterDataValidator {

    private RegisterActivity activityRef;

    public RegisterDataValidator(Context context) {
        this.activityRef = (RegisterActivity) context;
    }


    public boolean isDataValid() {
        return (validateUsername(activityRef.getUsername().getText().toString())
                && validatePassword(activityRef.getPassword().getText().toString())
                && validateEmail(activityRef.getEmail().getText().toString())
                && validatePhoneNumber(activityRef.getPhoneNumber().getText().toString())
                && validateFirstName(activityRef.getFirstName().getText().toString())
                && validateLastName(activityRef.getLastName().getText().toString())
            );
       }
    private boolean validatePhoneNumber(final String string){
        if(string.length() == 0){
            MyToast.showShort(activityRef, "Wpisany numer jest niepoprawny...");
            return false;
        }
        return true;
    }
    private boolean validateUsername(final String string) {
        if (string.length() < 3) {
            MyToast.showShort(activityRef, R.string.validation_error_username_shor);
            return false;
        }
        return true;
    }

    public boolean validatePassword(final String password) {
        Pattern pattern = Pattern.compile(Validation.PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches())
            return true;
        else {
            MyToast.showShort(activityRef,R.string.validation_password_security);
            return false;
        }
    }

    private boolean validateFirstName(final String name) {
        if (name.length() < 2) {
            MyToast.showShort(activityRef, R.string.validation_error_first);
            return false;
        }
        return true;
    }
    private boolean validateLastName(final String name) {
        if (name.length() < 2) {
            MyToast.showShort(activityRef, R.string.validation_error_last);
            return false;
        }
        return true;
    }

    public boolean validateEmail(final String EMAIL) {
        Pattern pattern = Pattern.compile(Validation.EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(EMAIL);
        if (matcher.matches())
            return true;
        else {
            MyToast.showShort(activityRef,R.string.validation_error_email_notvalid);
            return false;
        }
    }
}
