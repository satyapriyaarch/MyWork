package com.satya.mywork.mywork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MyworkActivity extends AppCompatActivity {


    Button addworkButton;

    Spinner spiner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mywork);


        ArrayList<String> stateList = new ArrayList<String>();

        String[] strs = getResources().getStringArray(R.array.Worked);
        for (int i=0;i<strs.length;i++)
        {
            stateList.add(strs[i]);
        }
        spiner = (Spinner) findViewById( R.id.spinner);
        addworkButton = (Button)findViewById(R.id.addworkButton);
        addworkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Satya","ButtonTouched");




            }
        });
        spiner.setAdapter(new SpinnerAdapter(MyworkActivity.this, stateList));


    }
}
