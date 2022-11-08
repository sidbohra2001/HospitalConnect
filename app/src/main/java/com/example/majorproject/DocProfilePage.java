package com.example.majorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DocProfilePage extends AppCompatActivity {

    TextView dispUserID1, dispDocsName, dispAge, dispLNo, dispExpYear, dispExp, dispField, dispDmobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_profile_page);
        String uid = getIntent().getExtras().getString("userID");
        dispUserID1 = findViewById(R.id.dispUserID1);
        dispDocsName = findViewById(R.id.dispDocsName);
        dispAge = findViewById(R.id.dispAge);
        dispLNo = findViewById(R.id.dispLNo);
        dispExpYear = findViewById(R.id.dispExpYear);
        dispExp = findViewById(R.id.dispExp);
        dispField = findViewById(R.id.dispField);
        dispDmobile = findViewById(R.id.dispDmobile);
        dispUserID1.setText(uid);
        String[] names = {"Ramesh Babu", "Suresh Singh", "Kamnath Bhajan", "Yedurappa Rao", "Jethalal Gada", "TVSJVK Tilak"};
        int i = (int)(Math.random()*5);
        String name = "Dr. "+names[i];
        dispDocsName.setText(name);
        Toast.makeText(DocProfilePage.this, "Logged In : "+name, Toast.LENGTH_SHORT).show();
        dispAge.setText(String.valueOf((int)(Math.random()*(25)+20)));
        dispLNo.setText(String.valueOf((int)(Math.random()*(8999998)+1000000)));
        dispExpYear.setText(String.valueOf((int)(Math.random()*10+2025)));
        dispExp.setText(String.valueOf((int)(Math.random()*5+10))+" Years");
        String[] fields = {"Pediatrician", "Gynecologist", "Physician", "Psychologist", "Dermatologist", "ENT Specialist", "Surgeon", "Dentist", "Cardiologist"};
        i = (int)(Math.random()*9);
        dispField.setText(fields[i]);
        String[] numbers = {"9856475866", "9854751254", "7485125455", "8152365874", "9125452587", "9325152475", "7854515245"};
        i = (int)(Math.random()*7);
        dispDmobile.setText(numbers[i]);
    }
}