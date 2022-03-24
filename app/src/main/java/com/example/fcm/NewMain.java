package com.example.fcm;

import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.displayunits.DisplayUnitListener;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;

import java.util.ArrayList;

public class NewMain extends AppCompatActivity implements DisplayUnitListener {

    Button sendBasicPush, sendCarouselPush,sendManualCarouselPush,sendFilmCarouselPush,
            sendRatingPush, sendProductDisplayNotification,
            sendLinearProductDisplayNotification,
            sendCTANotification, sendZeroBezel, sendTimerNotification,
            sendInputBoxNotification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TemplateRenderer.setDebugLevel(3);
        final CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            CleverTapAPI.createNotificationChannel(this,"Test","Push Template App Channel","Channel for Push Template App", NotificationManager.IMPORTANCE_HIGH,true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            CleverTapAPI.createNotificationChannel(this,"Tester","Push Template App Channel","Channel for Push Template App", NotificationManager.IMPORTANCE_HIGH,true);
        }

        sendBasicPush = findViewById(R.id.basicPush);
        sendBasicPush.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Basic Push");
            }
        });

        sendCarouselPush = findViewById(R.id.carouselPush);
        sendCarouselPush.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Auto Carousel Push");
            }
        });

        sendManualCarouselPush = findViewById(R.id.manualCarouselPush);
        sendManualCarouselPush.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Manual Carousel Push");

            }
        });

        sendFilmCarouselPush = findViewById(R.id.filmCarouselPush);
        sendFilmCarouselPush.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Filmstrip Carousel Push");
            }
        });


        sendRatingPush = findViewById(R.id.ratingPush);
        sendRatingPush.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Rating Push");
            }
        });

        sendProductDisplayNotification = findViewById(R.id.productDisplay);
        sendProductDisplayNotification.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Product Display Notification");

            }
        });

        sendLinearProductDisplayNotification = findViewById(R.id.linearProductDisplay);
        sendLinearProductDisplayNotification.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Linear Product Display Push");
            }
        });

        sendCTANotification = findViewById(R.id.cta);
        sendCTANotification.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send CTA Notification");
            }
        });

        sendZeroBezel = findViewById(R.id.zero_bezel);
        sendZeroBezel.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Zero Bezel Notification");
          //      Log.d("ID units",  cleverTapAPI.getDefaultInstance(this).getDisplayUnitForId("1647839756_20220321").toString());
                String s=CleverTapAPI.getDefaultInstance(this).getDisplayUnitForId("1647839756_20220321").toString();
                Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
            }
        });

        sendTimerNotification = findViewById(R.id.timer);
        sendTimerNotification.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Timer Notification");
            }

        });

        sendInputBoxNotification = findViewById(R.id.inputBox);
        sendInputBoxNotification.setOnClickListener(v -> {
            if (cleverTapAPI != null) {
                cleverTapAPI.pushEvent("Send Input Box Notification");
              Log.d("ALL DIsplay Units", String.valueOf(CleverTapAPI.getDefaultInstance(this).getAllDisplayUnits().size()));
              String s=CleverTapAPI.getDefaultInstance(this).getAllDisplayUnits().toString();
              Toast.makeText(getBaseContext(),s,Toast.LENGTH_LONG).show();
            }
        });
        CleverTapAPI.getDefaultInstance(this).setDisplayUnitListener(this);

    }

    @Override
    public void onDisplayUnitsLoaded(ArrayList<CleverTapDisplayUnit> units) {
        Log.d("Nativedisplay",units.toString());

    }


}