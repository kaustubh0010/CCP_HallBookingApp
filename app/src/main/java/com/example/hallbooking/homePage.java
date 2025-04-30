package com.example.hallbooking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.hallbooking.user.loginUser;
import com.example.hallbooking.user.updateUser;
import com.example.hallbooking.user.userHistory;
import com.example.hallbooking.user.userProfile;
import com.example.hallbooking.user.userTransactions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class homePage extends AppCompatActivity {

    CardView sportsCard, hallsCard, classroomsCard, lobbyCard, othersCard;

    DrawerLayout drawerLayout;
    LinearLayout sliderDots;
    BottomNavigationView bottomNavigationView;
    int dotsCount;
    ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        sportsCard = findViewById(R.id.cardView1);
        hallsCard = findViewById(R.id.cardView2);
        classroomsCard = findViewById(R.id.cardView3);
        lobbyCard = findViewById(R.id.cardView4);
        othersCard = findViewById(R.id.cardView5);
        sliderDots = findViewById(R.id.SliderDots);
        bottomNavigationView = findViewById(R.id.bottom_navigation);


        // drawable layout
        drawerLayout = findViewById(R.id.drawer_layout);

        // hamburger menu
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation item clicks here
                int id = item.getItemId();
                if (id == R.id.edit) {
                    Intent i = new Intent(homePage.this, updateUser.class);
                    startActivity(i);
                }
                else if (id == R.id.userHistory) {
                    Intent i = new Intent(homePage.this, userHistory.class);
                    startActivity(i);
                } else if (id == R.id.logout) {
                    Intent ii = new Intent(homePage.this, loginUser.class);

                    SharedPreferences sharedPreferences = getSharedPreferences("login_details", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    // Remove the "user_email" and "user_pass" data
                    editor.remove("user_email");
                    editor.remove("user_pass");
                    editor.apply();

                    Toast.makeText(homePage.this, "Logout Successfull", Toast.LENGTH_SHORT).show();
                    startActivity(ii);
                    finish();

                } else if (id == R.id.about) {
                    Intent iii = new Intent(homePage.this, aboutUs.class);
                    startActivity(iii);
                }

                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            }
        });

        Intent venueSelect_Page=new Intent(homePage.this, venueSelect.class);
        sportsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    venueSelect_Page.putExtra("type","Sports");
                    startActivity(venueSelect_Page);

            }
        });

        hallsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueSelect_Page.putExtra("type","Halls");
                startActivity(venueSelect_Page);
            }
        });

        classroomsCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueSelect_Page.putExtra("type","Classrooms");
                startActivity(venueSelect_Page);
            }
        });

        lobbyCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueSelect_Page.putExtra("type","Lobby");
                startActivity(venueSelect_Page);
            }
        });

        othersCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                venueSelect_Page.putExtra("type","Others");
                startActivity(venueSelect_Page);
            }
        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.navigation_transactions) {
                    Intent i=new Intent(homePage.this, userTransactions.class);
                    startActivity(i);
                    return true;
                }
                else if (item.getItemId() == R.id.navigation_profile) {
                    Intent i=new Intent(homePage.this, userProfile.class);
                    startActivity(i);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}