package com.example.cookbook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class NavigationDrawer extends AppCompatActivity {

    NavigationView nvgtn;
    DrawerLayout navdrawer;
    ActionBarDrawerToggle navtoggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        Toolbar navtoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(navtoolbar);

        nvgtn = (NavigationView)findViewById(R.id.nvgtn);
        navdrawer = (DrawerLayout)findViewById(R.id.navdrawer);
        navtoggle = new ActionBarDrawerToggle(this, navdrawer, navtoolbar, R.string.navopen, R.string.navclose);
        navdrawer.addDrawerListener(navtoggle);
        navtoggle.syncState();

        getSupportFragmentManager().beginTransaction().replace(R.id.fraglayout, new Dashboard()).commit();
        nvgtn.setCheckedItem(R.id.itemdashboard);
        nvgtn.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            Fragment tempfrag;
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.itemdashboard :
                        Toast.makeText(NavigationDrawer.this, "This is the Dashboard", Toast.LENGTH_LONG).show();
                        tempfrag = new Dashboard();
                        break;

                    case R.id.itemexplore :
                        Toast.makeText(NavigationDrawer.this, "This is the Explore Page", Toast.LENGTH_LONG).show();
                        tempfrag = new Explore();
                        break;

                    case R.id.itemsavedrec :
                        Toast.makeText(NavigationDrawer.this, "This is the Saved Recipes", Toast.LENGTH_LONG).show();
                        tempfrag = new SavedRecipes();
                        break;

                    case R.id.itemdownload :
                        Toast.makeText(NavigationDrawer.this, "This is the Downloads", Toast.LENGTH_LONG).show();
                        tempfrag = new Downloads();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fraglayout, tempfrag).commit();
                navdrawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });


    }
}