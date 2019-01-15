package com.kumbhar.admin.nfcattendance.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kumbhar.admin.nfcattendance.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUser;
    Button btnTeacher;
    Button btnAdmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        setListener();
    }

    private void setListener() {
        btnUser.setOnClickListener(this);
        btnTeacher.setOnClickListener(this);
        btnAdmin.setOnClickListener(this);
    }

    private void init() {
        btnUser = findViewById(R.id.btn_user);
        btnTeacher = findViewById(R.id.btn_teacher);
        btnAdmin = findViewById(R.id.btn_admin);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_user:{
                startActivity(new Intent(getApplicationContext(),UserActivity.class));
                break;
            }case R.id.btn_teacher:{
                startActivity(new Intent(getApplicationContext(),TeacherActivity.class));
                break;
            }case R.id.btn_admin:{
                startActivity(new Intent(getApplicationContext(),AdminActivity.class));
                break;
            }
        }
    }
}
