package com.lanceit.haito.lanceit.utils;

import android.content.Context;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.activities.RegisterActivity;
import com.lanceit.haito.lanceit.refference.Validation;

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
                && validateFirstName(activityRef.getFirstName().getText().toString())
                && validateLastName(activityRef.getLastName().getText().toString())
                && validateAge(activityRef.getAge().getText().toString())
            );
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

    private boolean validateAge(final String string) {
        if (string.length() == 0) {
            MyToast.showShort(activityRef, R.string.validation_error_age_null);
            return false;
        }

        int age = Integer.parseInt(string);
        if (age < 16) {
            MyToast.showShort(activityRef, R.string.validation_error_age_young);
            return false;
        } else if (age > 100) {
            MyToast.showShort(activityRef, R.string.validation_error_age_old);
            return false;
        }
        return true;
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
