package com.example.applicationidea.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.applicationidea.R;
import com.example.uilibrary.UiUtils;
import com.example.utilslibrary.Constants;
import com.example.utilslibrary.Utils;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.Map;

public class NewUserFragment extends Fragment {
    private UiUtils uiUtils;
    private Utils utils;

    private LoginButton loginButton;

    private View mView;
    private EditText editTextEmail, editTextPass1, editTextPass2;
    private Button buttonSignUp;

    private String email, pass1, pass2;

    private CallbackManager callbackManager;

    public NewUserFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_new_user, container, false);

        uiUtils = new UiUtils(getActivity());
        utils = new Utils(getActivity());

        initViews();

        return mView;
    }

    public void initViews() {
        editTextEmail = mView.findViewById(R.id.editTextNewUserEmail);
        editTextPass1 = mView.findViewById(R.id.editTextNewUserPass);
        editTextPass2 = mView.findViewById(R.id.editTextNewUserPass2);
        buttonSignUp = mView.findViewById(R.id.buttonSignUpEmail);

        callbackManager = CallbackManager.Factory.create();

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

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editTextEmail.getText().toString();
                pass1 = editTextPass1.getText().toString();
                pass2 = editTextPass2.getText().toString();

                Map<View, String> viewContentPair = new ArrayMap<>();
                viewContentPair.put(editTextEmail, email);
                viewContentPair.put(editTextPass1, pass1);
                viewContentPair.put(editTextPass2, pass2);

                ArrayList<View> unpop = utils.getUnpopulatedViews(viewContentPair);

                Log.d(Constants.TAG , "Unpop count: " + unpop.size());
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}