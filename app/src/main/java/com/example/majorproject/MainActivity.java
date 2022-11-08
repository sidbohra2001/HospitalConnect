package com.example.majorproject;

import static androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG;
import static androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricManager;
import androidx.core.content.ContextCompat;

import androidx.biometric.BiometricPrompt;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class MainActivity extends AppCompatActivity {

    TextView registerBtn;
    EditText userID, passwordInput;
    Button login_Btn;
    BiometricPrompt biometricPrompt;
    androidx.biometric.BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userID = findViewById(R.id.userIDInput);
        passwordInput = findViewById(R.id.passwordInput);
        login_Btn = findViewById(R.id.login_Btn);
        registerBtn = findViewById(R.id.registerBtn);
        BiometricManager biometricManager = BiometricManager.from(this);
        switch (biometricManager.canAuthenticate(BIOMETRIC_STRONG | DEVICE_CREDENTIAL)) {
            case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                Toast.makeText(getApplicationContext(), "Device doesn't support Fingerprint !!!", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                Toast.makeText(getApplicationContext(), "Device doesn't have Fingerprint Scanner !!!", Toast.LENGTH_SHORT).show();
                break;
            case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                // Prompts the user to create credentials that your app accepts.
                Toast.makeText(getApplicationContext(), "Device doesn't have Fingerprint !!!", Toast.LENGTH_SHORT).show();
                break;
        }
        Executor executor = ContextCompat.getMainExecutor(this);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            biometricPrompt = new BiometricPrompt(this, executor, new BiometricPrompt.AuthenticationCallback() {
                @Override
                public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                    super.onAuthenticationError(errorCode, errString);
                    Toast.makeText(getApplicationContext(),"Authentication error: " + errString, Toast.LENGTH_SHORT).show();
                    Log.e("mytag", passwordInput.getText().toString());
                    if(passwordInput.getText().toString().equals("doc")) {
                        Intent intent = new Intent(getApplicationContext(), DoctorHomePage.class);
                        intent.putExtra("userID", userID.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), PatientHomePage.class);
                        intent.putExtra("userID", userID.getText().toString());
                        startActivity(intent);
                    }
                }

                @Override
                public void onAuthenticationSucceeded(
                        @NonNull BiometricPrompt.AuthenticationResult result) {
                    super.onAuthenticationSucceeded(result);
                    Toast.makeText(getApplicationContext(),"Authentication succeeded!", Toast.LENGTH_SHORT).show();
                    Log.e("mytag", passwordInput.getText().toString());
                    if(passwordInput.getText().toString().equals("doc")) {
                        Intent intent = new Intent(getApplicationContext(), DoctorHomePage.class);
                        intent.putExtra("userID", userID.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), PatientHomePage.class);
                        intent.putExtra("userID", userID.getText().toString());
                        startActivity(intent);
                    }
                }

                @Override
                public void onAuthenticationFailed() {
                    super.onAuthenticationFailed();
                    Toast.makeText(getApplicationContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
                    if(passwordInput.getText().toString().equals("doc")) {
                        Intent intent = new Intent(getApplicationContext(), DoctorHomePage.class);
                        intent.putExtra("userID", userID.getText().toString());
                        startActivity(intent);
                    }
                    else{
                        Intent intent = new Intent(getApplicationContext(), PatientHomePage.class);
                        intent.putExtra("userID", userID.getText().toString());
                        startActivity(intent);
                    }
                }
            });
        }

        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Biometric Authentication")
                .setSubtitle("Log in using your biometric credential")
                .setNegativeButtonText("Use account password")
                .build();

        // Prompt appears when user clicks "Log in".
        // Consider integrating with the keystore to unlock cryptographic operations,
        // if needed by your app.
        login_Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                biometricPrompt.authenticate(promptInfo);
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Register Page", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(), Register.class);
//                startActivity(intent);
            }
        });
    }
}