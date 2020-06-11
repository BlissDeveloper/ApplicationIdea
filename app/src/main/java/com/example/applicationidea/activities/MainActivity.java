package com.example.applicationidea.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.applicationidea.R;
import com.example.applicationidea.fragments.LoginFragment;
import com.example.uilibrary.UiUtils;

public class MainActivity extends AppCompatActivity {
    private UiUtils uiUtils;

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiUtils = new UiUtils(MainActivity.this);

        loginFragment = new LoginFragment();

        uiUtils.loadFragment(R.id.frameLayoutMain, loginFragment);
    }
}