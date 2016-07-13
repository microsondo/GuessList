package com.example.microsondo.guesslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {


    Button beginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        beginButton = (Button) findViewById(R.id.beginButton);

        beginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTheOtherActivity = new Intent(getApplicationContext(), FirstScreen.class);
                startActivity(goToTheOtherActivity);
            }
        });


    }

    public static class FirstScreen extends AppCompatActivity {

        ImageButton firstImageButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_first_screen);

            firstImageButton = (ImageButton) findViewById(R.id.firstImageButton);

            firstImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToTheOtherActivity = new Intent(getApplicationContext(), SecondScreen.class);
                    startActivity(goToTheOtherActivity);
                }
            });


        }
    }

    public static class SecondScreen extends AppCompatActivity {
        ImageButton secondImageButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_second_screen);


            secondImageButton = (ImageButton) findViewById(R.id.secondImageButton);

            secondImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToOtherActivity = new Intent(getApplicationContext(), ThirdScreen.class);
                    startActivity(goToOtherActivity);
                }
            });

        }
    }

    public static class ThirdScreen extends AppCompatActivity {
        ImageButton thirdImageButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_third_screen);


            thirdImageButton = (ImageButton) findViewById(R.id.thirdImageButton);

            thirdImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToOtherActivity = new Intent(getApplicationContext(), ForthScreen.class);
                    startActivity(goToOtherActivity);
                }
            });

        }
    }

    public static class ForthScreen extends AppCompatActivity {
        ImageButton forthImageButton;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_forth_screen);


            forthImageButton = (ImageButton) findViewById(R.id.forthImageButton);

            forthImageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent goToOtherActivity = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(goToOtherActivity);
                }
            });

        }
    }

    public class LoginActivity extends MainActivity {
        CallbackManager callbackManager;
        LoginButton loginButton;


        public View OnCreateView(
                LayoutInflater inflater,
                ViewGroup container,
                Bundle savedInstanceState (

            View view = inflater.inflate(R.layout.activity_login, container, false);

            loginButton = (LoginButton) view.findViewById(R.id.loginButton);
            loginButton.setReadPermissions("email");

            loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                @Override
                public void onSuccess(LoginResult loginResult) {
                    // App code
                }

                @Override
                public void onCancel() {
                    // App code
                }

                @Override
                public void onError(FacebookException exception) {
                    // App code
                }
            });
        }));

        public static class LoginActivity extends AppCompatActivity {
            CallbackManager callbackManager;
            LoginButton loginButton;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                FacebookSdk.sdkInitialize(getApplicationContext());
                setContentView(R.layout.activity_login);
                loginButton = (LoginButton) findViewById(R.id.loginButton);
                loginButton.setReadPermissions("user_friends", "email", "public_profile");
                callbackManager = CallbackManager.Factory.create();
                // Other app specific specialization

                // Callback registration
                loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Intent goToOtherActivity = new Intent(getApplicationContext(), com.example.microsondo.guesslist.MainFrame.class);
                        startActivity(goToOtherActivity);


                        // App code

                    }

                    @Override
                    public void onCancel() {
                        // App code
                        Log.d("FACEBOOK----->", "onCancel");
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Log.d("FACEBOOK----->", "onError");
                    }
                });
            }

        }