package com.example.applicationidea.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.applicationidea.R;
import com.example.applicationidea.fragments.LoginFragment;
import com.example.uilibrary.UiUtils;

public class MainActivity extends AppCompatActivity {
    private UiUtils uiUtils;

    private LoginFragment loginFragment;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uiUtils = new UiUtils(MainActivity.this);

        loginFragment = new LoginFragment();

        initViews();

        uiUtils.loadFragment(R.id.frameLayoutMain, loginFragment);
    }

    public void initViews() {
        toolbar = findViewById(R.id.toolbarMain);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }
}