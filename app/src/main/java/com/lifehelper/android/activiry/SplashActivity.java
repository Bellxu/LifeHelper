package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lifehelper.android.R;
import com.lifehelper.android.user.UserConfig;
import com.lifehelper.android.util.PreferencesUtils;

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
        LoginActivity.startActivity(this);

    }

    private void toHome() {
        HomeActivity.startActivity(this);
    }

    private boolean checkLogin() {
        if (PreferencesUtils.getString(this, UserConfig.USER_ID) != null) {
            return true;
        }
        return false;
    }
}