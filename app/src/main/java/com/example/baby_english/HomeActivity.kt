package com.example.baby_english

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import android.content.DialogInterface
import android.util.Log
import androidx.appcompat.app.AlertDialog
import com.example.baby_english.R.string
import com.google.android.gms.ads.*
import kotlinx.android.synthetic.main.activity_main.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback


class HomeActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    private var mInterstitialAd: InterstitialAd? = null
    private final var TAG = "HomeActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        MobileAds.initialize(this) {}



        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        InterstitialAd.load(this,"ca-app-pub-3940256099942544/1033173712", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d(TAG, adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded.")
                mInterstitialAd = interstitialAd
            }
        })


        btn_start.setOnClickListener {
            startActivity(Intent(applicationContext, MainActivity::class.java))
            finish()
        }
        btn_about.setOnClickListener {
             startActivity(Intent(applicationContext,AboutActivity::class.java))
            finish()
        }
        btn_share.setOnClickListener {
            val myIntent = Intent(Intent.ACTION_SEND)
            myIntent.type = "text/plain"
            val body = "Your body here"
            val sub = "Your Subject"
            myIntent.putExtra(Intent.EXTRA_SUBJECT, sub)
            myIntent.putExtra(Intent.EXTRA_TEXT, body)
            startActivity(Intent.createChooser(myIntent, "Share Using"))
        }
        btn_exit.setOnClickListener {
            val builder: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(this@HomeActivity)
            builder.setMessage("Do you want to exit ?")
            builder.setCancelable(true)
            builder.setNegativeButton("YES",
                DialogInterface.OnClickListener { dialog, which -> finish() })
            builder.setPositiveButton("NO",
                DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })
            val alertDialog: android.app.AlertDialog? = builder.create()
            alertDialog?.show()

        }




    }
}