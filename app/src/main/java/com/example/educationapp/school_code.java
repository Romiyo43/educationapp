package com.example.educationapp;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class school_code extends AppCompatActivity {
    private EditText editTextUserId;
    private Button buttonLogin;
    private TextView textViewStatus;
    SharedPreferences sharedPreferences;

    // Dummy list of user IDs for demonstration purposes
    protected List<String> userIDs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_code);

        editTextUserId = findViewById(R.id.editTextUserId);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewStatus = findViewById(R.id.textViewStatus);
        sharedPreferences=getSharedPreferences("school_code",MODE_PRIVATE);
        Intent intent = new Intent(school_code.this, login_page.class);
        if(sharedPreferences.contains("editTextUserId")){
            startActivity(intent);
            finish();
        }

        // Initialize the list of user IDs (replace this with your actual user IDs)
        userIDs = new ArrayList<>();
        userIDs.add("user1");
        userIDs.add("user2");

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editTextUserId.getText().toString().trim();

                // Check if the user ID exists in the list of userIDs
                if (userIDs.contains(userId)) {
                    // User ID found, move to the next page
                    textViewStatus.setVisibility(View.GONE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("editTextUserId", String.valueOf(editTextUserId));
                    editor.commit();
                    startActivity(intent);
                    finish();
                } else {
                    // User ID not found
                    textViewStatus.setText("User ID not found");
                    textViewStatus.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
