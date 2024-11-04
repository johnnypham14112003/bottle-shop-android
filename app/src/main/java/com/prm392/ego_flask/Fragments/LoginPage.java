package com.prm392.ego_flask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;

import com.prm392.ego_flask.R;
import com.prm392.ego_flask.utils.SessionManager;

public class LoginPage extends Fragment {
        private EditText etUsername, etPassword;
        private Button btnLogin;
        private ImageButton btnBack;
        private SessionManager sessionManager;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.layout_signin, container, false);

            sessionManager = new SessionManager(requireContext());

            etUsername = view.findViewById(R.id.etUsername);
            etPassword = view.findViewById(R.id.etPassword);
            //btnLogin = view.findViewById(R.id.btnLogin);
            //btnBack = view.findViewById(R.id.btnBack);

            btnLogin.setOnClickListener(v -> {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                // Thực hiện kiểm tra đăng nhập ở đây
                // Giả sử đăng nhập thành công:
//                sessionManager.createLoginSession("user123", username);

                // Quay lại fragment trước đó
                requireActivity().getSupportFragmentManager().popBackStack();
            });

            btnBack.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().popBackStack();
            });

            return view;
        }
}
