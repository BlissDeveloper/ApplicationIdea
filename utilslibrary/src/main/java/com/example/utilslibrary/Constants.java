package com.example.utilslibrary;

import java.util.regex.Pattern;

public class Constants {
    public static final String TAG = "Avery";

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public static final Pattern PASSWORD_REGEX =
            Pattern.compile("^(?=.*[a-z].*[a-z].*[a-z])(?=.*[0-9].*[0-9]).{6}$");
}
