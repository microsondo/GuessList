package com.example.microsondo.guesslist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.AccessToken;

import java.util.Arrays;

public class LoginActivity extends MainActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CallbackManager mCallbackManager;
        getHandleFacebookAccessToken(loginResult.getAccessToken);

    mCallbackManager= CallbackManager.Factory.create();
    LoginButton loginButton = (LoginButton) findViewById(R.id.loginButton);
    loginButton.setReadPermissions("email", "public_profile");
    loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {


        @Override
        public void onSuccess(LoginResult loginResult) {
            Log.d(TAG, "facebook:onSuccess:" + loginResult);
            handleFacebookAccessToken(loginResult.getAccessToken());
        }

        @Override
        public void onCancel() {
            Log.d(TAG, "facebook:onCancel");
            // ...
        }

        @Override
        public void onError(FacebookException error) {
            Log.d(TAG, "facebook:onError", error);
            // ...
        }
    });


}

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

        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            callbackManager.onActivityResult(requestCode, resultCode, data);
            LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends"));
            Intent goToOtherActivity = new Intent(getApplicationContext(), com.example.microsondo.guesslist.MainFrame.class);
            startActivity(goToOtherActivity);


        }


        public class MainFrame extends MainActivity {

            @Override
            public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                FacebookSdk.sdkInitialize(getApplicationContext());
                callbackManager = CallbackManager.Factory.create();
                LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
                    public void onSuccess(LoginResult loginResult) {

                    }

                    public void onCancel() {

                    }

                    public void onError(FacebookException error) {

                    }

                });
            }
            @Override
            protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                callbackManager.onActivityResult(requestCode, resultCode, data);
            }

        }

    }
}


