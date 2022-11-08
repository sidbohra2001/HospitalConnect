package com.example.majorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.GregorianCalendar;

public class PatProfilePage extends AppCompatActivity {

    TextView disp_pat_userid, disp_pat_name, disp_pat_age, disp_pat_dob, disp_pat_gender, disp_pat_allergies, disp_pat_mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pat_profile_page);
        String uid = getIntent().getExtras().getString("userID");
        disp_pat_userid = findViewById(R.id.disp_pat_userid);
        disp_pat_name = findViewById(R.id.disp_pat_name);
        disp_pat_age = findViewById(R.id.disp_pat_age);
        disp_pat_dob = findViewById(R.id.disp_pat_dob);
        disp_pat_gender = findViewById(R.id.disp_pat_gender);
        disp_pat_allergies = findViewById(R.id.disp_pat_allergies);
        disp_pat_mobile = findViewById(R.id.disp_pat_mobile);
        disp_pat_userid.setText(uid);
        String[] names = {"Ramesh Babu", "Suresh Singh", "Kamnath Bhajan", "Yedurappa Rao", "Jethalal Gada", "TVSJVK Tilak"};
        String[] gender = {"Male", "Female"};
        int i = (int)(Math.random()*5);
        String name = names[i];
        String g = gender[i%2];
        disp_pat_name.setText(name);
        Toast.makeText(PatProfilePage.this, "Logged In : "+name, Toast.LENGTH_SHORT).show();
        disp_pat_gender.setText(g);
        GregorianCalendar gc = new GregorianCalendar();
        int year = randBetween(1946, 2015);
        int day = randBetween(1,28);
        int month = randBetween(1,12);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            LocalDate dob = LocalDate.of(year, month, day);
            LocalDate currDate = LocalDate.now();
            Period age = Period.between(dob,currDate);
            String ageText = age.getYears() +" years";
            disp_pat_age.setText(ageText);
            disp_pat_dob.setText(dob.toString());
        }
        String[] allergies = {"Drug Allergy", "Skin Allergy", "Food Allergy", "Latex Allergy", "Pollen Allergy", "Mold Allergy", "Insect Allergy"};
        String[] numbers = {"9856475866", "9854751254", "7485125455", "8152365874", "9125452587", "9325152475", "7854515245"};
        i = (int)(Math.random()*7);
        disp_pat_mobile.setText(numbers[i]);
        disp_pat_allergies.setText(allergies[i]);
    }

    public static int randBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}