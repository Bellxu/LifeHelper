package com.lifehelper.android.activiry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.lifehelper.android.databinding.ActivitySettingBinding;
import com.lifehelper.android.user.UserConfig;
import com.lifehelper.android.user.UserInfoManger;
import com.lifehelper.android.util.PreferencesUtils;

public class SettingActivity extends BaseActivity {
    private ActivitySettingBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());
        mViewBinding.imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        mViewBinding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferencesUtils.putString(SettingActivity.this, UserConfig.USER_NAME, null);
                UserInfoManger.getInstance().setUser(null);
                LoginActivity.startActivity(SettingActivity.this);
                finish();
            }
        });
        mViewBinding.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                Uri data = Uri.parse("tel:" + "18817334366");
                intent.setData(data);
                startActivity(intent);
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