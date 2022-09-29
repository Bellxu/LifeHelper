package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.lifehelper.android.databinding.ActivitySettingBinding;
import com.lifehelper.android.user.UserConfig;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.PreferencesUtils;

public class SettingActivity extends AppCompatActivity {
    private ActivitySettingBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());
        mViewBinding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesUtils.putString(SettingActivity.this, UserConfig.USER_NAME, null);
                UserInfoManger.getInstance().setUser(null);
                LoginActivity.startActivity(SettingActivity.this);
                finish();
            }
        });
    }

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        context.startActivity(intent);
    }
}