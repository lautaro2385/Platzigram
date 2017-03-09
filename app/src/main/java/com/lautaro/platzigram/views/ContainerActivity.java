package com.lautaro.platzigram.views;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lautaro.platzigram.R;
import com.lautaro.platzigram.views.fragments.HomeFragment;
import com.lautaro.platzigram.views.fragments.ProfileFragment;
import com.lautaro.platzigram.views.fragments.SearchFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class ContainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);

        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        bottomBar.setDefaultTab(R.id.tab_home);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment selectFragment = null;
                switch (tabId) {
                    case R.id.tab_home:
                        selectFragment = new HomeFragment();
                        break;
                    case R.id.tab_profile:
                        selectFragment = new ProfileFragment();
                        break;
                    case R.id.tab_search:
                        selectFragment = new SearchFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.container, selectFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                        .addToBackStack(null)
                        .commit();
            }
        });

    }
}
