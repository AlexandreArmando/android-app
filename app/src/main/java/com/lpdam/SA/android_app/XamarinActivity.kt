package com.lpdam.SA.android_app

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_xamarin.*

class XamarinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTitle("Xamarin")
        setContentView(R.layout.activity_xamarin)
        setSupportActionBar(toolbar)
        xamarinButton.setOnClickListener { view ->
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://docs.microsoft.com/en-us/xamarin/get-started/first-app/?pivots=windows")
            startActivity(url)
        }
    }
}
