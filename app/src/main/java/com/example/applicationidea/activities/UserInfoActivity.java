package com.example.applicationidea.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.applicationidea.R;

public class UserInfoActivity extends AppCompatActivity {
    private Toolbar toolbar;

    private EditText editTextFirstName, editTextMiddleName, editTextLastName, editTextDOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initViews();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }

    public void initViews() {
        toolbar = findViewById(R.id.toolbarUserInfo);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getString(R.string.tell_us_about));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
