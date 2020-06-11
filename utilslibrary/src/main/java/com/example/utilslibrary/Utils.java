package com.example.utilslibrary;

import android.content.Context;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Matcher;

public class Utils {
    private Context context;

    public Utils(Context context) {
        this.context = context;
    }

    public boolean isEmailValid(final String email) {
        Matcher matcher = Constants.VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }

    public boolean isPasswordValid(String password) {
        Matcher matcher = Constants.PASSWORD_REGEX.matcher(password);
        return matcher.find();
    }

    public ArrayList<View> getUnpopulatedViews(Map<View, String> viewContentPair) {
        ArrayList<View> unpopulatedViews = new ArrayList<>();

        for (View view : viewContentPair.keySet()) {
            if (TextUtils.isEmpty(viewContentPair.get(view))) {
                unpopulatedViews.add(view);
            }
        }
        return unpopulatedViews;
    }

    public void toJson(Object object) {
        Gson gson = new Gson();
        Log.d(Constants.TAG, gson.toJson(object));
    }

}
