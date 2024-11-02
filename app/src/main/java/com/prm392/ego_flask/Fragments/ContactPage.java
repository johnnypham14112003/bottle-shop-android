package com.prm392.ego_flask.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.prm392.ego_flask.R;

public class ContactPage extends Fragment {

    private CardView btnFacebook, btnInstagram, btnCall;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        btnFacebook = view.findViewById(R.id.btnFacebook);
        btnInstagram = view.findViewById(R.id.btnInstagram);

        // Xử lý sự kiện click Facebook
        btnFacebook.setOnClickListener(v -> {
            try {
                String url = "https://www.facebook.com/people/Ego-Flask/61566267320324/"; // Thay thế bằng URL Facebook của bạn
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(getContext(), "Không thể mở Facebook", Toast.LENGTH_SHORT).show();
            }
        });

        // Xử lý sự kiện click Instagram
        btnInstagram.setOnClickListener(v -> {
            try {
                String url = "https://www.instagram.com/egoflaskvietnam/"; // Thay thế bằng URL Instagram của bạn
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(getContext(), "Không thể mở Instagram", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}