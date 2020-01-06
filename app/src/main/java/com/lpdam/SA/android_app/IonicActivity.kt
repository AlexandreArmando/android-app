package com.lpdam.SA.android_app

import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_ionic.*
import kotlinx.android.synthetic.main.content_flutter.*

class IonicActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ionic)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://ionicframework.com/getting-started/")
            startActivity(url)
        }

        scrollView.setOnScrollChangeListener { _, _, scrollY,  _, _ ->
            val percent : Float = scrollY.toFloat() / (linearLayout.height.toFloat() - 1543) * 100

            MainActivity.progressionViewModel.ionicProgression = "Ionic ${percent.toInt()}%"
        }
    }
}
