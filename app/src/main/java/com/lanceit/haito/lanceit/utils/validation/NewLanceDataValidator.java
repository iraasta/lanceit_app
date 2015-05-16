package com.lanceit.haito.lanceit.utils.validation;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.utils.CommonUtilities;
import com.lanceit.haito.lanceit.utils.MyToast;
import com.lanceit.haito.lanceit.view.hub.hubFragments.AddFragment;

public class NewLanceDataValidator {
    private AddFragment fragmentRefference;

    public NewLanceDataValidator(AddFragment fragmentRefference) {
        this.fragmentRefference = fragmentRefference;
    }

    public boolean isDataValid() {
        return (validateTitle() && validateExpiration() && validaPrice() );
    }

    public boolean validateTitle() {
        if(fragmentRefference.getTitleText().getText().toString().length() > 3){
            return true;
        } else {
            MyToast.showShort(fragmentRefference.getParentActivity(), R.string.validation_error_title);
            return false;
        }
    }

    public boolean validateExpiration() {
        String toTest = fragmentRefference.getExpireText().getText().toString();
        if(toTest.length() > 0){
            return true;
        } else {
            MyToast.showShort(fragmentRefference.getParentActivity(),R.string.validation_error_expiration);
            return false;
        }
    }

    public boolean validaPrice(){
        String toTest = fragmentRefference.getPrice().getText().toString();
        if (CommonUtilities.isDouble(toTest)) {
            return true;
        } else {
            MyToast.showShort(fragmentRefference.getParentActivity(), R.string.validation_error_price);
            return false;
        }
    }
}
