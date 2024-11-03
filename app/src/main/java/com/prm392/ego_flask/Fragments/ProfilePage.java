package com.prm392.ego_flask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.prm392.ego_flask.R;
import com.prm392.ego_flask.utils.SessionManager;

public class ProfilePage extends Fragment {

    private Button btnLoginLogout;
    private TextView tvUsername;
    private SessionManager sessionManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        //=====================================================================================


        //=====================================================================================
        return view;
    }
}