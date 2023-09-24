package com.example.educationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class class_work extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ImageView menu;
    LinearLayout profile, class_work, home_work, attendance, result, fee, notification, video_lecture, add_user, log_out;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_work);

        drawerLayout = findViewById(R.id.drawableLayout);
        menu = findViewById(R.id.menu);
        profile = findViewById(R.id.profile);
        class_work = findViewById(R.id.class_work);
        home_work = findViewById(R.id.home_work);
        attendance = findViewById(R.id.attendance);
        fee = findViewById(R.id.fee);
        result = findViewById(R.id.result);
        notification = findViewById(R.id.notification);
        video_lecture = findViewById(R.id.video_lecture);
        add_user = findViewById(R.id.add_user);
        log_out = findViewById(R.id.log_out);
        sharedPreferences=getSharedPreferences("school_code", MODE_PRIVATE);

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, student_profile.class);
            }
        });
        class_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, class_work.class);
            }
        });
        home_work.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, home_work.class);
            }
        });
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, attendance.class);
            }
        });
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, fees.class);
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, exam_result.class);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, notification.class);
            }
        });
        video_lecture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, video_lecture.class);
            }
        });
        add_user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redirectActivity(class_work.this, add_student.class);
            }
        });
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Intent intent = new Intent(class_work.this,school_code.class);
                startActivity(intent);
                finish();
            }
        });



    }

    public static void openDrawer(DrawerLayout drawerLayout){
        drawerLayout.openDrawer(GravityCompat.START);
    }
    public static void closeDrawer(DrawerLayout drawerLayout){
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }
    public static void redirectActivity(Activity activity, Class secondActivity){

        Intent intent = new Intent(activity, secondActivity);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        closeDrawer(drawerLayout);
    }
}