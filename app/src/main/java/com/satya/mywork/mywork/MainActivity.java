package com.satya.mywork.mywork;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    View loginView,signupView;
    Button loginButton,signupButton;
    EditText emailText,passwordText,confPassText;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        emailText = (EditText)findViewById(R.id.emailText);
        passwordText = (EditText)findViewById(R.id.passwordText);

        loginButton = (Button)findViewById(R.id.loginButton);

        signupButton = (Button)findViewById(R.id.signupButton);


        confPassText = (EditText)findViewById(R.id.confPasswordText);

        signupButton.setVisibility(View.INVISIBLE);
        confPassText.setVisibility(View.INVISIBLE);

        loginView = (View)findViewById(R.id.loginView);

        loginView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                loginView.setBackgroundResource(R.color.selectedTab);
                signupView.setBackgroundResource(R.color.deSelectedTab);

                signupButton.setVisibility(View.INVISIBLE);
                confPassText.setVisibility(View.INVISIBLE);
                loginButton.setVisibility(View.VISIBLE);

                return true;
            }
        });

        signupView = (View)findViewById(R.id.signupView);

        signupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                loginView.setBackgroundResource(R.color.deSelectedTab);
                v.setBackgroundResource(R.color.selectedTab);


                signupButton.setVisibility(View.VISIBLE);
                confPassText.setVisibility(View.VISIBLE);
                loginButton.setVisibility(View.INVISIBLE);


                return true;
            }
        });


        signupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String email = emailText.getText().toString().trim();
                    String password = passwordText.getText().toString().trim();
                    String confirmpass = confPassText.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password)) {
                        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (TextUtils.isEmpty(confirmpass)) {
                        Toast.makeText(getApplicationContext(), "Enter confirm password!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (!TextUtils.equals(password.toString(), confirmpass.toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Password and Confirm password does not match!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (password.length() < 3) {
                        Toast.makeText(getApplicationContext(), "Password too short, enter minimum 3 characters!", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    //create user
                    auth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    Toast.makeText(MainActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (!task.isSuccessful()) {

                                        Toast.makeText(MainActivity.this, "Authentication failed." + task.getException(),
                                                Toast.LENGTH_SHORT).show();
                                    } else {

                                        Intent intent = new Intent(MainActivity.this,MyworkActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }

                                }
                            });
                }
        });

        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v)
                    {

                        String email = emailText.getText().toString().trim();
                        String password = passwordText.getText().toString().trim();
                        String confirmpass = confPassText.getText().toString().trim();
                        if (TextUtils.isEmpty(email)) {
                            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (TextUtils.isEmpty(password)) {
                            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (password.length() < 6) {
                            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        //authenticate user
                        auth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        // If sign in fails, display a message to the user. If sign in succeeds
                                        // the auth state listener will be notified and logic to handle the
                                        // signed in user can be handled in the listener.
                                        //progressBar.setVisibility(View.GONE);
                                        if (!task.isSuccessful()) {
                                            // there was an error
                                            Toast.makeText(MainActivity.this, "Authentication failed." + task.getException(),
                                                    Toast.LENGTH_SHORT).show();

                                        } else {
                                            Intent intent = new Intent(MainActivity.this, MyworkActivity.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                });





                    }
                }


        );

    }



}
