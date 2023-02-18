package com.example.bottamnavexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.bottamnavexample.ads.AdMob;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            bottomNavigationView = findViewById(R.id.bnView);

        AdMob.serBanner(findViewById(R.id.banner),MainActivity.this);

            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    int id = item.getItemId();

                    if (id==R.id.nav_home){
                        loadFrag(new homeFragment(),false);
                    }else if (id==R.id.nav_search){

                        loadFrag(new SearchFragment(),false);
                    }else if (id == R.id.nav_utilities){
                        loadFrag(new UtilitiesFragment(),false);
                    }else if (id == R.id.contact){
                        loadFrag(new ContactFragment(),false);
                    }else {
                        loadFrag(new profileFragment(),true);
                    }
                    return true;
                }
            });
        bottomNavigationView.setSelectedItemId(R.id.nav_mypro);
    }

    public void loadFrag(Fragment fragment, boolean flag){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag){
            ft.add(R.id.container,fragment);
        }else {
            ft.replace(R.id.container,fragment);
        }
        ft.commit();
    }
}