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

        sessionManager = new SessionManager(requireContext());

        btnLoginLogout = view.findViewById(R.id.btnLoginLogout);
        tvUsername = view.findViewById(R.id.tvUsername);

        updateUI();

        btnLoginLogout.setOnClickListener(v -> {
            if (sessionManager.isLoggedIn()) {
                sessionManager.logout();
                updateUI();
            } else {
                navigateToLogin();
            }
        });

        //=====================================================================================
        return view;
    }

    private void updateUI() {
        if (sessionManager.isLoggedIn()) {
            btnLoginLogout.setText("Đăng xuất");
            tvUsername.setText("Xin chào, " + sessionManager.getUsername());
        } else {
            btnLoginLogout.setText("Đăng nhập");
            tvUsername.setText("Vui lòng đăng nhập");
        }
    }

    private void navigateToLogin() {
        FragmentTransaction ft = requireActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment_container, new LoginPage());
        ft.addToBackStack(null);
        ft.commit();
    }
}