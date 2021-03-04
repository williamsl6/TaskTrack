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
import android.widget.TextView;


import com.example.stopwatch.R;
import com.google.android.material.navigation.NavigationView;

import java.util.Locale;




public class MainActivity extends AppCompatActivity {


    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    /*
    Use seconds, running and wasRunning respectively.
     to record the number of seconds passed, whether
     the stopwatch is running, was running or paused.*/


    //Number of seconds passed on the stopwatch.
    private int sec = 0;

    //Is stopwatch running?
    private boolean running;
    //Was the stopwatch running?
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.view);
        toolbar = findViewById(R.id.nav_home);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState != null) {
            //Get the previous state of the stopwatch
            //if teh activity has been destroyed
            //and recreated.

            sec = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();

    }
    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.navi) {

            // This code will start the new activity when the settings button is clicked on the bar at the top.
            Intent intent = new Intent(mainPage.this, mainPage.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */


    /*
     *  Start the stopwatch when start is clicked.
     */
    public void onClickStart(View view) {

        running = true;
    }

    /*
     *  Stop the stopwatch when stop is clicked.
     */
    public void onClickStop (View view){
        running = false;
    }
    /*
     * Reset the stopwatch with the reset button.
     */
    public void onClickReset(View view) {
        running = false;
        sec = 0;
    }

    /*
     * Sets number of seconds on timer and uses handler to
     * increment the seconds and text view.
     */
    private void runTimer() {

        //get text view.
        final TextView timeView = (TextView)findViewById(R.id.time_view);


        //Creates a new handler.
        final Handler handler = new Handler();

        handler.post(new Runnable(){

            @Override
            public void run(){


                int hours = sec/3600;
                int minutes = (sec % 3600) / 60;
                int second = sec % 60;

                //formats time into hours, minutes, and seconds.
                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, minutes, second);

                //Select the text view text
                timeView.setText(time);

                //if stopwatch is running then increment the seconds variable.
                if(running)
                    sec++;

                handler.postDelayed(this, 1000);

            }

        });
    }

}