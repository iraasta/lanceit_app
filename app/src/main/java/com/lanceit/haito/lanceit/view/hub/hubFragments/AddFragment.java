package com.lanceit.haito.lanceit.view.hub.hubFragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.lanceit.haito.lanceit.R;
import com.lanceit.haito.lanceit.view.hub.HubActivity;
import com.lanceit.haito.lanceit.network.lanceHandler.AppendLance;
import com.lanceit.haito.lanceit.utils.validation.NewLanceDataValidator;

public class AddFragment extends Fragment {

    public static final String[] CATEGORIES = {
            "Kupno/Zakupy",
            "Informatyka",
            "Przynieś",
            "Zanieś",
            "Pozamiataj"
    };

    private Button confrimButton;
    private EditText titleText;
    private EditText descriptionText;
    private EditText expireText;
    private EditText price;
    private Spinner categorySpinner;

    private HubActivity parentActivity;
    private OnFragmentInteractionListener mListener;

    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public AddFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        categorySpinner = (Spinner) view.findViewById(R.id.category_spinner);
        confrimButton = (Button) view.findViewById(R.id.confirm_bt);
        descriptionText = (EditText) view.findViewById(R.id.description_text);
        expireText = (EditText) view.findViewById(R.id.expire_text);
        titleText = (EditText) view.findViewById(R.id.title_text);
        price = (EditText) view.findViewById(R.id.price);

        Log.d("Create Add Fragment","Expire text: " + expireText.toString() + "\n title "+ titleText.getText().toString());
        Log.d("Title Edit Text Reffernce", getTitleText().toString());

        categorySpinner.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_spinner_dropdown_item, CATEGORIES));

        confrimButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Activity Checker", parentActivity.toString());
                if(new NewLanceDataValidator(AddFragment.this).isDataValid()) {
                    new AppendLance(parentActivity)
                            .setFragment(AddFragment.this)
                            .sendRequest();
                }
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public HubActivity getParentActivity() {
        return parentActivity;
    }

    public void setParentActivity(HubActivity parentActivity) {
        this.parentActivity = parentActivity;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

    public Button getConfrimButton() {
        return confrimButton;
    }

    public EditText getTitleText() {
        return titleText;
    }

    public EditText getDescriptionText() {
        return descriptionText;
    }

    public EditText getExpireText() {
        return expireText;
    }

    public Spinner getCategorySpinner() {
        return categorySpinner;
    }

    public EditText getPrice() {
        return price;
    }
}
