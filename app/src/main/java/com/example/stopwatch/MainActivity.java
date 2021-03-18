package com.example.stopwatch;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.stopwatch.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;




public class MainActivity extends AppCompatActivity {


    public DrawerLayout drawerLayout;
    public NavigationView navigationView;
    public Toolbar toolbar;

    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button that refers to Timer.class
        button = (Button) findViewById(R.id.timer);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Timer.class);
                startActivity(intent);
            }

        });

        // code for the drawer in app.
        /*
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.view);
        toolbar = findViewById(R.id.nav_home);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        */



        }


    }