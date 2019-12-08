package com.app.zapiskztest.Activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.app.zapiskztest.Fragment.MainFragment;
import com.app.zapiskztest.Fragment.ProfileFragment;
import com.app.zapiskztest.Fragment.SearchFragment;
import com.app.zapiskztest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onCreate(savedInstanceState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        final Fragment mainFragment = new MainFragment();
        final Fragment searchFragment = new SearchFragment();
        final Fragment profileFragment = new ProfileFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, mainFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, searchFragment).hide(searchFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout, profileFragment).hide(profileFragment).commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.action_fragment_main:
                        getSupportFragmentManager().beginTransaction().hide(searchFragment).show(mainFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(profileFragment).show(mainFragment).commit();
                        getSupportFragmentManager().beginTransaction().show(mainFragment).commit();
                        break;

                    case R.id.action_fragment_search:
                        getSupportFragmentManager().beginTransaction().hide(mainFragment).show(searchFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(profileFragment).show(searchFragment).commit();
                        getSupportFragmentManager().beginTransaction().show(searchFragment).commit();
                        break;

                    case R.id.action_fragment_profile:
                        getSupportFragmentManager().beginTransaction().hide(searchFragment).show(profileFragment).commit();
                        getSupportFragmentManager().beginTransaction().hide(mainFragment).show(profileFragment).commit();
                        getSupportFragmentManager().beginTransaction().show(profileFragment).commit();
                        break;
                }
                return true;
                }
            }
        );

    }
}
