package com.example.majorproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class PatientHomePage extends AppCompatActivity {


    TextView patName;
    ImageButton patProfIcon, bookAppointIcon, reportsIcon, docDetIcon, prescIcon, visitsIcon, contactUsIcon;
    ConstraintLayout patConstraintLayout;
    DrawerLayout patDrawerLayout;
    Toolbar patToolbar;
    ActionBarDrawerToggle patToggle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home_page);


        //Initialising Buttons
        patName = findViewById(R.id.patName);
        String s = getIntent().getExtras().getString("userID");
        String s1 = "Welcome "+s;
        patName.setText(s1);
        patProfIcon = findViewById(R.id.patProfIcon);
        bookAppointIcon = findViewById(R.id.bookAppointIcon);
        reportsIcon = findViewById(R.id.reportsIcon);
        docDetIcon = findViewById(R.id.docDetIcon);
        prescIcon = findViewById(R.id.prescIcon);
        visitsIcon = findViewById(R.id.visitsIcon);
        contactUsIcon = findViewById(R.id.contactUsIcon);
        patDrawerLayout = findViewById(R.id.patDrawerLayout);
        patConstraintLayout = findViewById(R.id.patConstraintLayout);
        patToolbar = findViewById(R.id.toolbar);
        patToolbar.setTitle("Patient Home Page");
        patToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        patDrawerLayout.addDrawerListener(patToggle);
        patToggle = new ActionBarDrawerToggle(this, patDrawerLayout, patToolbar, R.string.nav_open, R.string.nav_close);
        patToggle.syncState();
        configureNavigationDrawer();

        //setOnClickListeners for icons
        patProfIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PatientHomePage.this, PatProfilePage.class);
                intent.putExtra("userID", s);
                startActivity(intent);
            }
        });
        bookAppointIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomePage.this, "Book Appointment Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        reportsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomePage.this, "Reports Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        docDetIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomePage.this, "Doctor's Details Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        prescIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomePage.this, "Prescription Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        visitsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomePage.this, "Visits Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
        contactUsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PatientHomePage.this, "Contact Us Page !!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main_drawer, menu);
        return true;
    }

    private void configureNavigationDrawer(){
        NavigationView patNavigationView = findViewById(R.id.patNavigationView);
        patNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemID = item.getItemId();
                if(itemID == R.id.nav_home){
                    Toast.makeText(PatientHomePage.this, "HomePage", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_doctors){
                    Toast.makeText(PatientHomePage.this, "Doctors", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_appointments){
                    Toast.makeText(PatientHomePage.this, "Appointments", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_services){
                    Toast.makeText(PatientHomePage.this, "Services", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_clinics){
                    Toast.makeText(PatientHomePage.this, "Clinics", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_news){
                    Toast.makeText(PatientHomePage.this, "News", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_about_us){
                    Toast.makeText(PatientHomePage.this, "About Us", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_contacts){
                    Toast.makeText(PatientHomePage.this, "Contacts", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_settings){
                    Toast.makeText(PatientHomePage.this, "Settings", Toast.LENGTH_SHORT).show();
                }
                else if(itemID == R.id.nav_logout){
                    Toast.makeText(PatientHomePage.this, "Logout", Toast.LENGTH_SHORT).show();
                }
                return false;

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(patToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}