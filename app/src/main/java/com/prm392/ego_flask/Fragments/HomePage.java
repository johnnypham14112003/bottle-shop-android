package com.prm392.ego_flask.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.prm392.ego_flask.R;

public class HomePage extends Fragment {
    private CardView btnBottlePurle, btnBottleOrange, btnBottleBlue, btnBottlePink;
    private ImageView imgBottlePurle, imgBottleOrange, imgBottleBlue, imgBottlePink;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_homepage, container, false);
        //=====================================================================================
        btnBottlePurle = view.findViewById(R.id.btnBottlePurple);
        btnBottleOrange = view.findViewById(R.id.btnBottleOrange);
        btnBottleBlue = view.findViewById(R.id.btnBottleBlue);
        btnBottlePink = view.findViewById(R.id.btnBottlePink);

        imgBottlePurle = view.findViewById(R.id.imgBottlePurple);
        imgBottleOrange = view.findViewById(R.id.imgBottleOrange);
        imgBottleBlue = view.findViewById(R.id.imgBottleBlue);
        imgBottlePink = view.findViewById(R.id.imgBottlePink);

        //Code more in here...

        //=====================================================================================
        return view;
    }
}
