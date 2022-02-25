package com.example.baby_english

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_alphabet.*

class AlphabetActivity : AppCompatActivity() {
    lateinit var mAdView : AdView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alphabet)

        var name= intent.getStringExtra("name")?.toLowerCase()
        Toast.makeText(applicationContext,name,Toast.LENGTH_SHORT).show()

        var id=resources.getIdentifier(name,"drawable",packageName)
        imageView.setImageResource(id)

        var mid=resources.getIdentifier(name,"raw",packageName)
        var mp=MediaPlayer.create(applicationContext,mid)
        mp.start()

        imag_back.setOnClickListener{
            var intent = Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


    }
}