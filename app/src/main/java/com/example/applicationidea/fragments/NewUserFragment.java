package com.example.applicationidea.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.applicationidea.R;
import com.example.utilslibrary.Constants;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class NewUserFragment extends Fragment {
    private LoginButton loginButton;
    private View mView;

    private CallbackManager callbackManager;

    public NewUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_new_user, container, false);

        initViews();

        return mView;
    }

    public void initViews() {
        callbackManager = CallbackManager.Factory.create();

        loginButton = mView.findViewById(R.id.buttonFBLogin);
        loginButton.setPermissions("email", "public_profile");

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                Log.d(Constants.TAG, "Facebook login success!");
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


}