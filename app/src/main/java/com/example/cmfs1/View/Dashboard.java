package com.example.cmfs1.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.cmfs1.R;
import com.google.android.material.navigation.NavigationView;

public class Dashboard extends AppCompatActivity  {
    Button btn_dashboard;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Toolbar toolbar_dashboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        btn_dashboard = findViewById(R.id.btn_dashboard);
        navigationView = findViewById(R.id.navigation_view_dash_board);
        drawerLayout = findViewById(R.id.drawer_dash_board);
        toolbar_dashboard = findViewById(R.id.toolbar_dashboard);
        setSupportActionBar(toolbar_dashboard);
        toolbar_dashboard.setTitle("DashBoard");
        toolbar_dashboard.setTitleTextColor(Color.WHITE);

        setUpToolbar();
        setUpNavigation();


    }

    private void setUpNavigation() {
        Menu nav_menu = navigationView.getMenu();
        nav_menu.findItem(R.id.menu_updateKYC).setVisible(true).getActionView();
        nav_menu.findItem(R.id.menu_personalDetails).setVisible(true).getActionView();
        nav_menu.findItem(R.id.menu_bankDetails).setVisible(true).getActionView();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                drawerLayout.closeDrawers();
                switch (item.getItemId()) {

                    case R.id.menu_updateKYC:
                        startActivity(new Intent(getApplicationContext(), UpdateKYCActivity.class));
                        finish();
                        break;

                    case R.id.menu_personalDetails:
                        startActivity(new Intent(getApplicationContext(), PersonalDetails.class));
                        finish();
                        break;

                    case R.id.menu_bankDetails:
                        startActivity(new Intent(getApplicationContext(), BankDetails.class));
                        finish();
                        break;
                }

                return true;
            }
        });
    }

    private void setUpToolbar() {
        setSupportActionBar(toolbar_dashboard);
        toolbar_dashboard.setTitleTextColor(Color.WHITE);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar_dashboard, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case  R.id.menu_updateKYC:
                startActivity(new Intent(getApplicationContext(), UpdateKYCActivity.class));
                finish();
                break;

            case R.id.menu_personalDetails:
                startActivity(new Intent(getApplicationContext(), PersonalDetails.class));
                finish();
                break;

            case R.id.menu_bankDetails:
                startActivity(new Intent(getApplicationContext(), BankDetails.class));
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}