package com.lifehelper.android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

//闪屏页
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (checkLogin()) {
            toHome();
        } else {
            toLogin();
        }
    }

    private void toLogin() {
    }

    private void toHome() {
        HomeActivity.startActivity(this);
    }

    private boolean checkLogin() {
        return true;
    }
}