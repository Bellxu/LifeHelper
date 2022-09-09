package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;

import com.lifehelper.android.dao.DbManger;
import com.lifehelper.android.dao.User;
import com.lifehelper.android.databinding.ActivityLoginBinding;
import com.lifehelper.android.util.RegexUtils;
import com.lifehelper.android.util.ToastUtils;

import java.util.List;

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
                Editable userName = mViewBinding.etUserName.getText();
                Editable password = mViewBinding.etPassword.getText();
                int i = checkUserInfo(userName.toString(), password.toString());
                if (i == 0) {
                    HomeActivity.startActivity(LoginActivity.this);
                    finish();
                } else if (i == 1) {
                    ToastUtils.showToast(LoginActivity.this, "请先注册");
                } else {
                    ToastUtils.showToast(LoginActivity.this, "密码错误");
                }
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
                    if (!DbManger.getInstance().getmAppDatabase().userDao().queryUsersBytName(userName.toString()).isEmpty()) {
                        ToastUtils.showToast(LoginActivity.this, "账号已存在，请不要重复注册");
                    }
                    DbManger.getInstance().getmAppDatabase().userDao().insertUser(user);
                    ToastUtils.showToast(LoginActivity.this, "注册成功,点击登陆继续");
                }
            }
        });

    }

    private int checkUserInfo(String userName, String password) {
        List<User> users = DbManger.getInstance().getmAppDatabase().userDao().queryUsersBytName(userName);
        if (users.isEmpty()) {
            return 1;
        } else {
            boolean has = false;
            for (User user : users) {
                if (user.password.equals(password)) {
                    has = true;
                }
                if (has) {
                    return 0;
                } else {
                    return 2;
                }
            }

        }
        //0 登陆成功 1 未注册 2 账号密码错误
        return 0;
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