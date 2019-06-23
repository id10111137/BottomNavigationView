package com.example.tatangit.bottomnavigationview;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.tatangit.bottomnavigationview.Fragment.FragmentA;
import com.example.tatangit.bottomnavigationview.Fragment.FragmentB;
import com.example.tatangit.bottomnavigationview.Fragment.FragmentC;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {



    @BindView(R.id.btn_navigation_mInfo)
    BottomNavigationView bottomNavigationView;

    Fragment fragment;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupNavigationView();

    }


    private void setupNavigationView() {

        if (bottomNavigationView != null) {

            // Select first menu item by default and show Fragment accordingly.
            Menu menu = bottomNavigationView.getMenu();
            selectmInfo(menu.getItem(0));

            // Set action to perform when any menu-item is selected.
            bottomNavigationView.setOnNavigationItemSelectedListener(
                    new BottomNavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                            selectmInfo(item);
                            return false;
                        }
                    });
        }
    }


    protected void selectmInfo(MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()) {
            case R.id.IdMenuA:
                pushFragment(new FragmentA());
                break;
            case R.id.IdMenuB:
                pushFragment(new FragmentB());
                break;
            case R.id.IdMenuC:
                pushFragment(new FragmentC());
                break;
        }
    }


    protected void pushFragment(Fragment fragment) {
        if (fragment == null)
            return;

        fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction ft = fragmentManager.beginTransaction();
            if (ft != null) {
                ft.replace(R.id.frame_homes, fragment);
                ft.commit();
            }
        }
    }


}
