package com.satya.mywork.mywork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyworkActivity extends AppCompatActivity {


    Button addworkButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywork);

        addworkButton = (Button)findViewById(R.id.addworkButton);
        addworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Satya","ButtonTouched");




            }
        });


    }
}
