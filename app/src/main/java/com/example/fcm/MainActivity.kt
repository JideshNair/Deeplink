package com.example.fcm

import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.CanceledException
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clevertap.android.sdk.CTInboxListener
import com.clevertap.android.sdk.CleverTapAPI
import com.clevertap.android.sdk.pushnotification.CTPushNotificationListener
import com.google.android.material.snackbar.Snackbar
import java.sql.DriverManager.println
import java.util.*

class MainActivity : AppCompatActivity(), CTInboxListener  {
    lateinit var FAB: View;
    var clevertapDefaultInstance: CleverTapAPI? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        clevertapDefaultInstance?.getCleverTapID {
// Callback on main thread


        }

        clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)   //Initializing the CleverTap SDK
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FAB=  findViewById(R.id.fab)
		CleverTapAPI.createNotificationChannel(
            getApplicationContext(),
            "Tester",
            "mychannel",
            "lDescription",
            NotificationManager.IMPORTANCE_MAX,
            true
        )        //added by CleverTap Assistant
        setSupportActionBar(findViewById(R.id.toolbar))
        val cleverTapAPI = CleverTapAPI.getDefaultInstance(applicationContext)
			CleverTapAPI.setDebugLevel(3)

        FAB.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun inboxDidInitialize() {


    }

    override fun inboxMessagesDidUpdate() {
      Log.d("message updated", "message updated this is awesome")
    }


}
