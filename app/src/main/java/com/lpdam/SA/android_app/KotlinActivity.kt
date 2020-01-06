package com.lpdam.SA.android_app

import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_kotlin.*
import kotlinx.android.synthetic.main.content_flutter.*

class KotlinActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)
        setSupportActionBar(toolbar)
        fab.setOnClickListener {
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://kotlinlang.org/docs/tutorials/getting-started.html")
            startActivity(url)
        }

        scrollView.setOnScrollChangeListener { _, _, scrollY,  _, _ ->
            val percent : Float = scrollY.toFloat() / (linearLayout.height.toFloat() - 1536) * 100

            MainActivity.progressionViewModel.kotlinProgression = "Kotlin ${percent.toInt()}%"
        }
    }
}
