package com.example.fcm


import android.app.NotificationManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.*
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.clevertap.android.pushtemplates.TemplateRenderer
import com.clevertap.android.sdk.CTInboxListener
import com.clevertap.android.sdk.CleverTapAPI
import com.google.android.material.snackbar.Snackbar
import java.util.*


class MainActivity : AppCompatActivity(), CTInboxListener  {

    val sendBasicPush: Button? = null;
    var sendCarouselPush:Button? = null; var sendManualCarouselPush:Button? = null; var sendFilmCarouselPush:Button? = null;

    var sendRatingPush: Button? = null; var sendProductDisplayNotification:Button? = null;
    var sendLinearProductDisplayNotification: Button? = null;
    var sendCTANotification: Button? = null; var sendZeroBezel:Button? = null; var sendTimerNotification:Button? = null;
    var sendInputBoxNotification: Button? = null

    var clevertapDefaultInstance: CleverTapAPI? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        val data: Uri? = intent.data
        setContentView(R.layout.activity_main);
        data?.getQueryParameter("key")
        clevertapDefaultInstance?.getCleverTapID {

            TemplateRenderer.debugLevel=3;
            val cleverTapAPI = CleverTapAPI.getDefaultInstance(applicationContext)

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                CleverTapAPI.createNotificationChannel(this, "Test", "Push Template App Channel", "Channel for Push Template App", NotificationManager.IMPORTANCE_HIGH, true)
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                CleverTapAPI.createNotificationChannel(this, "Tester", "Push Template App Channel", "Channel for Push Template App", NotificationManager.IMPORTANCE_HIGH, true)
            }

           val sendBasicPush = findViewById(R.id.basicPush) as Button
            sendBasicPush.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Basic Push")
                Toast.makeText(baseContext,"Here iam",Toast.LENGTH_LONG).show();
            })


           val sendCarouselPush = findViewById(R.id.carouselPush) as Button
            sendCarouselPush.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Auto Carousel Push")
            })

            sendManualCarouselPush = findViewById(R.id.manualCarouselPush)
            sendManualCarouselPush?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Manual Carousel Push")
            })

            sendFilmCarouselPush = findViewById(R.id.filmCarouselPush)
            sendFilmCarouselPush?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Filmstrip Carousel Push")
            })


            sendRatingPush = findViewById(R.id.ratingPush)
            sendRatingPush?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Rating Push")
            })

            sendProductDisplayNotification = findViewById(R.id.productDisplay)
            sendProductDisplayNotification?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Product Display Notification")
            })

            sendLinearProductDisplayNotification = findViewById(R.id.linearProductDisplay)
            sendLinearProductDisplayNotification?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Linear Product Display Push")
            })

            sendCTANotification = findViewById(R.id.cta)
            sendCTANotification?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send CTA Notification")
            })

            sendZeroBezel = findViewById(R.id.zero_bezel)
            sendZeroBezel?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Zero Bezel Notification")
            })

            sendTimerNotification = findViewById(R.id.timer)
            sendTimerNotification?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Timer Notification")
            })

            sendInputBoxNotification = findViewById(R.id.inputBox)
            sendInputBoxNotification?.setOnClickListener(OnClickListener { v: View? ->
                cleverTapAPI?.pushEvent("Send Input Box Notification")
            })

        }

        clevertapDefaultInstance = CleverTapAPI.getDefaultInstance(applicationContext)   //Initializing the CleverTap SDK
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
