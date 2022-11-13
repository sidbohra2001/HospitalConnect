package com.example.majorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class DoctorHomePage extends AppCompatActivity {

    TextView docName;
    ImageButton profIcon, appointIcon, fPatIcon, addPatIcon, availIcon;
    ConstraintLayout constraintLayout;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home_page);
        String s = getIntent().getExtras().getString("userID");
        constraintLayout = findViewById(R.id.constraintLayout);

        //initialize elements
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);

        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //getSupportActionBar().setHomeButtonEnabled(true);
        toolbar.setTitle("Doctor Home Page");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        drawerLayout.addDrawerListener(toggle);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.nav_open, R.string.nav_close);
        toggle.syncState();
        docName = findViewById(R.id.docName);
        String s1 = "Welcome Dr. "+s;
        docName.setText(s1);
        profIcon = findViewById(R.id.profIcon);
        appointIcon = findViewById(R.id.appointIcon);
        fPatIcon = findViewById(R.id.fPatIcon);
        addPatIcon = findViewById(R.id.addPatIcon);
        availIcon = findViewById(R.id.availIcon);

        configureNavigationDrawer();

        //setOnClickListeners for icons
        profIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DoctorHomePage.this, DocProfilePage.class);
                intent.putExtra("userID", s);
                startActivity(intent);
            }
        });
        appointIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorHomePage.this, "Appointment Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        fPatIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorHomePage.this, "Find Patient Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        addPatIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorHomePage.this, "Add Patient Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        availIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DoctorHomePage.this, "Availability Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    private void configureNavigationDrawer(){
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if(itemID == R.id.nav_home){
                    Toast.makeText(DoctorHomePage.this, "HomePage", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_doctors){
                    Toast.makeText(DoctorHomePage.this, "Doctors", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_appointments){
                    Toast.makeText(DoctorHomePage.this, "Appointments", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_services){
                    Toast.makeText(DoctorHomePage.this, "Services", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_clinics){
                    Toast.makeText(DoctorHomePage.this, "Clinics", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_news){
                    Toast.makeText(DoctorHomePage.this, "News", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_about_us){
                    Toast.makeText(DoctorHomePage.this, "About Us", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_contacts){
                    Toast.makeText(DoctorHomePage.this, "Contacts", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_settings){
                    Toast.makeText(DoctorHomePage.this, "Settings", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_logout){
                    Toast.makeText(DoctorHomePage.this, "Logout", Toast.LENGTH_SHORT).show();
                }
                return false;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return toggle.onOptionsItemSelected(item);
    }
}