package com.example.hp.s_100;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.hp.s_100.Fragment.AboutFragment;
import com.example.hp.s_100.Fragment.BlankFragment;
import com.example.hp.s_100.Fragment.Services_Fragment;
import com.example.hp.s_100.Fragment.Shop_Fragment;
import com.example.hp.s_100.Fragment.SupportFragment;
import com.example.hp.s_100.Fragment.Wash_Fragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private String titleBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new BlankFragment()).commit();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.promotions) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new BlankFragment()).commit();
            titleBar = getResources().getString(R.string.promotions_menu);

        } else if (id == R.id.nav_car_wash) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Wash_Fragment()).commit();
            titleBar = getResources().getString(R.string.wash_menu);

        } else if (id == R.id.nav_service) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Services_Fragment()).commit();
            titleBar = getResources().getString(R.string.service_menu);

        } else if (id == R.id.nav_shop) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new Shop_Fragment()).commit();
            titleBar = getResources().getString(R.string.shop_menu);

        } else if (id == R.id.nav_feedback) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new SupportFragment()).commit();
            titleBar = getResources().getString(R.string.feedback_menu);

        } else if (id == R.id.nav_about) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, new AboutFragment()).commit();
            titleBar = getResources().getString(R.string.about_menu);
        }
        Log.d("TAG", titleBar);
        setActionBarTitle(titleBar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setActionBarTitle(String actionBarTitle) {
        if (actionBarTitle == null) {
            getSupportActionBar().setTitle(getResources().getString(R.string.app_name));

        } else
            getSupportActionBar().setTitle(actionBarTitle);

    }
}
