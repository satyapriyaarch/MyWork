package com.satya.mywork.mywork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    View loginView,signupView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginView = (View)findViewById(R.id.loginView);
        loginView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                loginView.setBackgroundResource(R.color.selectedTab);
                signupView.setBackgroundResource(R.color.deSelectedTab);
                return true;
            }
        });

        signupView = (View)findViewById(R.id.signupView);
        signupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                loginView.setBackgroundResource(R.color.deSelectedTab);
                v.setBackgroundResource(R.color.selectedTab);
                return true;
            }
        });

    }


}
