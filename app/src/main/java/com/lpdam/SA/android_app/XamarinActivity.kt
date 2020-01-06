package com.lpdam.SA.android_app

import android.annotation.TargetApi
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_xamarin.*
import kotlinx.android.synthetic.main.content_flutter.*

class XamarinActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_xamarin)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://docs.microsoft.com/en-us/xamarin/get-started/#get-started")
            startActivity(url)
        }

        scrollView.setOnScrollChangeListener { view, scrollX, scrollY,  oldScrollX, oldScrollY ->
            val percent : Float = scrollY.toFloat() / (linearLayout.height.toFloat() - 1534) * 100

            MainActivity.progressionViewModel.xamarinProgression = "Xamarin ${percent.toInt()}%"
        }
    }
}
