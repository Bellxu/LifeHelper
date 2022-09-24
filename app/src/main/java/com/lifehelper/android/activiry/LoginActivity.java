package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.dao.User;
import com.lifehelper.android.databinding.ActivityLoginBinding;
import com.lifehelper.android.user.UserConfig;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.PreferencesUtils;
import com.lifehelper.android.util.RegexUtils;
import com.lifehelper.android.util.ToastUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());
        initView();
        initListener();
    }

    private void initListener() {
        mViewBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mViewBinding.etUserName.getText().toString();
                String password = mViewBinding.etPassword.getText().toString();
                checkUserInfo(userName, password, new userInfoCallBack() {
                    @Override
                    public void onUserInfo(User user, int status) {
                        Log.i("xsk--", "onUserInfo: "+Thread.currentThread().getName());
                        if (status == 0) {
                            HomeActivity.startActivity(LoginActivity.this);
                            PreferencesUtils.putString(LoginActivity.this, UserConfig.USER_NAME, userName);
                            UserInfoManger.getInstance().setUser(user);
                            finish();
                        } else if (status == 1) {
                            ToastUtils.showToast(LoginActivity.this, "请先注册");
                        } else {
                            ToastUtils.showToast(LoginActivity.this, "密码错误");
                        }

                    }
                });
            }
        });
        mViewBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable userName = mViewBinding.etUserName.getText();
                Editable password = mViewBinding.etPassword.getText();
                if (TextUtils.isEmpty(RegexUtils.checkPasWord(password.toString()))) {
                    ToastUtils.showToast(LoginActivity.this, "密码只能输入字母和数字的特殊字符");
                } else {
                    User user = new User();
                    user.userName = userName.toString();
                    user.password = password.toString();
                    if (!DbManger.getInstance().getAppDatabase().userDao().queryUsersBytName(userName.toString()).isEmpty()) {
                        ToastUtils.showToast(LoginActivity.this, "账号已存在，请不要重复注册");
                    }
                    DbManger.getInstance().getAppDatabase().userDao().insertUser(user);
                    ToastUtils.showToast(LoginActivity.this, "注册成功,点击登陆继续");
                }
            }
        });

    }

    interface userInfoCallBack {
        void onUserInfo(User user, int status);
    }

    private void checkUserInfo(String userName, String password, userInfoCallBack userInfoCallBack) {
        List<User> users = DbManger.getInstance().getAppDatabase().userDao().queryUsersBytName(userName);
        if (users.isEmpty()) {
            userInfoCallBack.onUserInfo(null, 1);
        } else {
            for (User user : users) {
                if (user.password.equals(password)) {
                    userInfoCallBack.onUserInfo(user, 0);
                    break;
                }
            }
            userInfoCallBack.onUserInfo(null, 2);
        }

        //0 登陆成功 1 未注册 2 账号密码错误
        userInfoCallBack.onUserInfo(null, 1);
    }

    private void initView() {

    }


    public static void startActivity(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }


}