package com.example.fcm;

import android.app.Application;
import android.app.PendingIntent;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.clevertap.android.sdk.ActivityLifecycleCallback;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener;


import java.util.HashMap;

public class Applicationnew extends Application implements CTPushNotificationListener {
    @Override
    public void onCreate() {
        CleverTapAPI.setDebugLevel(3);
        ActivityLifecycleCallback.register(this);
        super.onCreate();
        CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());

        cleverTapAPI.setCTPushNotificationListener(this);

    }

    @Override
    public void onNotificationClickedPayloadReceived(HashMap<String, Object> payload) {
        Log.d("testCDPL", payload.toString());
        if (payload.containsKey("CDPL")) {
            switch (payload.get("CDPL").toString()) {
                case "test":
                    Toast.makeText(getApplicationContext(),"Reaching here",Toast.LENGTH_LONG).show();


            }
        }
    }
}
