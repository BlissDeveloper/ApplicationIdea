package com.example.applicationidea.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.applicationidea.R;
import com.example.uilibrary.Utils;
import com.example.utilslibrary.Constants;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class NewUserFragment extends Fragment {
    private LoginButton loginButton;

    private View mView;
    private EditText editTextEmail, editTextPass1, editTextPass2;

    private CallbackManager callbackManager;

    public NewUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_new_user, container, false);

        Log.d(Constants.TAG, "New user fragment");

        initViews();

        return mView;
    }

    public void initViews() {
        callbackManager = CallbackManager.Factory.create();

        editTextEmail = mView.findViewById(R.id.editTextNewUserEmail);
        editTextPass1 = mView.findViewById(R.id.editTextNewUserPass);
        editTextPass2 = mView.findViewById(R.id.editTextNewUserPass2);

        loginButton = mView.findViewById(R.id.buttonFBLogin);
        loginButton.setPermissions("email", "public_profile");
        loginButton.setFragment(this);

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(Constants.TAG, "Facebook login success!");
                Log.d(Constants.TAG, "Login result: " + loginResult);
            }

            @Override
            public void onCancel() {
                Log.e(Constants.TAG, "Facebook login cancelled.");
            }

            @Override
            public void onError(FacebookException error) {
                Log.e(Constants.TAG, error.getMessage());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}