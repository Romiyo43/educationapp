package com.example.educationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class login_page extends AppCompatActivity {

    private EditText editTextUserId;
    private EditText editTextPassword;
    private Button buttonLogin;
    private TextView textViewStatus;
    SharedPreferences sharedPreferences;

    // Dummy user data for demonstration purposes
    private Map<String, String> userCredentials;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

                editTextUserId = findViewById(R.id.username);
                editTextPassword = findViewById(R.id.password);
                buttonLogin = findViewById(R.id.login_but);
                textViewStatus = findViewById(R.id.error1);
                sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
                Intent intent = new Intent(login_page.this, marks_1.class);
                if(sharedPreferences.contains("editTextUserId")&&sharedPreferences.contains("editTextPassword")){
                    startActivity(intent);
                    finish();
                }


                // Initialize the user credentials map (replace this with your actual user data)
                userCredentials = new HashMap<>();
                userCredentials.put("user1", "password1");
                userCredentials.put("user2", "password2");


                buttonLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String userId = editTextUserId.getText().toString().trim();
                        String password = editTextPassword.getText().toString().trim();

                        // Check if the user ID exists in the userCredentials map
                        if (userCredentials.containsKey(userId)) {
                            // Compare the provided password with the stored password for the given user ID
                            String storedPassword = userCredentials.get(userId);
                            if (password.equals(storedPassword)) {
                                // Password matches, login successful, move to the next page
                                textViewStatus.setVisibility(View.GONE);
                                SharedPreferences.Editor editor=sharedPreferences.edit();
                                editor.putString("editTextUserId", String.valueOf(editTextUserId));
                                editor.putString("editTextPassword",String.valueOf(editTextPassword));
                                editor.commit();
                                startActivity(intent);
                                finish();
                            } else {
                                // Incorrect password
                                textViewStatus.setText("Incorrect password");
                                textViewStatus.setVisibility(View.VISIBLE);
                            }
                        } else {
                            // User ID not found
                            textViewStatus.setText("User ID not found");
                            textViewStatus.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }
}