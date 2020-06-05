package com.example.applicationidea.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.applicationidea.R;
import com.example.applicationidea.fragments.LoginFragment;
import com.example.uilibrary.Utils;

public class MainActivity extends AppCompatActivity {
    private Utils utils;

    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        utils = new Utils(MainActivity.this);

        loginFragment = new LoginFragment();

        utils.loadFragment(R.id.frameLayoutMain, loginFragment);
    }
}