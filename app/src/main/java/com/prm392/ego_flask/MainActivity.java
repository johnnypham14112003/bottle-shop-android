package com.prm392.ego_flask;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prm392.ego_flask.Fragments.ContactPage;
import com.prm392.ego_flask.Fragments.DesignPage;
import com.prm392.ego_flask.Fragments.HomePage;
import com.prm392.ego_flask.Fragments.ProductsPage;
import com.prm392.ego_flask.Fragments.ProfilePage;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bottom_navigation);

        fragmentManager = getSupportFragmentManager();
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Thiết lập listener cho bottom navigation
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            int itemId = item.getItemId();

            if (itemId == R.id.navigation_home) {
                selectedFragment = new HomePage();

            } else if (itemId == R.id.navigation_products) {
                selectedFragment = new ProductsPage();

            } else if (itemId == R.id.navigation_design) {
                selectedFragment = new DesignPage();

            } else if (itemId == R.id.navigation_contact) {
                selectedFragment = new ContactPage();

            } else if (itemId == R.id.navigation_profile) {
                selectedFragment = new ProfilePage();
            }

            if (selectedFragment != null) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, selectedFragment)
                        .commit();
                return true;
            }
            return false;
        });

        // Hiển thị fragment mặc định
        if (savedInstanceState == null) {
            bottomNavigationView.setSelectedItemId(R.id.navigation_home);
        }
    }
}