package com.example.uilibrary;

import android.app.Activity;
import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class Utils {
    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public void loadFragment(int frameId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction().replace(frameId, fragment);
        fragmentTransaction.commit();
    }


}
