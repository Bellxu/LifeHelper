package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;

import com.lifehelper.android.R;
import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.dao.User;
import com.lifehelper.android.user.UserConfig;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.PreferencesUtils;

import java.util.List;

//闪屏页
public class SplashActivity extends BaseActivity {
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
        finish();

    }

    private void toHome() {
        HomeActivity.startActivity(this);
        finish();

    }

    private boolean checkLogin() {
        String string = PreferencesUtils.getString(this, UserConfig.USER_NAME);
        if (!TextUtils.isEmpty(string)) {
            List<User> users = DbManger.getInstance().getAppDatabase().userDao().queryUsersBytName(string);
            UserInfoManger.getInstance().setUser(users.get(0));
            return true;
        }
        return false;
    }
}