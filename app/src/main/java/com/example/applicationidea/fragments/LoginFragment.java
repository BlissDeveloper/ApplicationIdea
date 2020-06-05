package com.example.applicationidea.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.applicationidea.R;
import com.example.uilibrary.Utils;


public class LoginFragment extends Fragment {
    private Utils utils;

    private View mView;
    private EditText editTextEmail, editTextPassword;
    private Button buttonSubmit;
    private TextView textViewNewUser;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, container, false);

        utils = new Utils(getActivity());

        initViews();

        return mView;
    }

    public void initViews() {
        editTextEmail = mView.findViewById(R.id.editTextEmail);
        editTextPassword = mView.findViewById(R.id.editTextPassword);
        buttonSubmit = mView.findViewById(R.id.buttonSubmitMain);
        textViewNewUser = mView.findViewById(R.id.textViewNewUser);

        textViewNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                utils.loadFragment(R.id.frameLayoutMain, new NewUserFragment());
            }
        });
    }
}