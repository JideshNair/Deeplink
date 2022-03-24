package com.example.fcm

import android.app.Application
import android.util.Log
import android.widget.Toast
import com.clevertap.android.pushtemplates.PushTemplateNotificationHandler
import com.clevertap.android.sdk.ActivityLifecycleCallback
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.interfaces.NotificationHandler
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener
import java.util.*


class Applicationnew : Application(), CTPushNotificationListener {

    override fun onCreate() {
        CleverTapAPI.setDebugLevel(3)
        ActivityLifecycleCallback.register(this)
        CleverTapAPI.setNotificationHandler(PushTemplateNotificationHandler() as NotificationHandler);
        super.onCreate()
        val cleverTapAPI = CleverTapAPI.getDefaultInstance(applicationContext)
        cleverTapAPI!!.ctPushNotificationListener = this


    }

    override fun onNotificationClickedPayloadReceived(payload: HashMap<String, Any>) {
        Log.d("testCDPL", payload.toString())
        if (payload.containsKey("CDPL")) {
            when (payload["CDPL"].toString()) {
                "test" -> Toast.makeText(applicationContext, "Reaching here", Toast.LENGTH_LONG).show()
            }
        }
    }
}