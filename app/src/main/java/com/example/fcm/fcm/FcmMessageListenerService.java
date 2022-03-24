package com.example.fcm.fcm;


import android.app.NotificationManager;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.util.Log;

import com.clevertap.android.pushtemplates.TemplateRenderer;
import com.clevertap.android.sdk.CleverTapAPI;


import com.clevertap.android.sdk.Utils;
import com.clevertap.android.sdk.interfaces.OnInitCleverTapIDListener;
import com.clevertap.android.sdk.pushnotification.NotificationInfo;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

//******************* PLEASE MAKE SURE TO ADD THE GOOGLE_SERVICES.JSON FILE IN TO THE PROJECT DIRECTORY***************//
public class FcmMessageListenerService extends FirebaseMessagingService {

	CleverTapAPI clevertapDefaultInstance;
	@Override
	public void onMessageReceived(RemoteMessage remoteMessage) {
		super.onMessageReceived(remoteMessage);

	}

	@Override
	public void onNewToken(@NonNull String s) {
		super.onNewToken(s);
		clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(getApplicationContext());
		clevertapDefaultInstance.pushFcmRegistrationId(s,true);
		CleverTapAPI.createNotificationChannel(this,"Tester","Tester","Channel for Push in App", NotificationManager.IMPORTANCE_HIGH,true);
	}


}