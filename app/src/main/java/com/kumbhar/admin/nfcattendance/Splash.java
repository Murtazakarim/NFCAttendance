package com.kumbhar.admin.nfcattendance;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kumbhar.admin.nfcattendance.Activities.MainActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread td = new Thread(){

            @Override
            public void run() {
                try{
                    sleep(3000);
                }catch (Exception ex){
                    ex.printStackTrace();
                }finally {
                    Intent it = new Intent(Splash.this,MainActivity.class);
                    startActivity(it);
                }
            }
        };td.start();
    }
}
