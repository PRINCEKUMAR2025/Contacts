package com.prince5326.contacts;

import android.app.Application;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;

import java.util.List;

public class ApplicationClass extends Application {
    public static final String APPLICATION_ID = "241DA653-A6C0-DDC0-FF36-A831FA58CB00";
    public static final String API_KEY = "0A1C7BA0-3B36-4A9E-B464-C2827CB1DD0D";
    public static final String SERVER_URL = "https://api.backendless.com";

    public static BackendlessUser user;
    public static List<Contact> contacts;

    public void onCreate(){
        super.onCreate();

        Backendless.setUrl( SERVER_URL );
        Backendless.initApp( getApplicationContext(),
                APPLICATION_ID,
                API_KEY );
    }
}
