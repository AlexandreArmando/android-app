package com.lpdam.SA.android_app

import android.annotation.TargetApi
import android.content.Intent
import android.content.res.XmlResourceParser
import android.net.Uri
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.marginEnd
import androidx.core.view.size
import androidx.lifecycle.ViewModelProviders
import com.lpdam.SA.android_app.ui.progression.ProgressionViewModel
import kotlinx.android.synthetic.main.activity_flutter.*
import kotlinx.android.synthetic.main.content_flutter.*
import kotlinx.android.synthetic.main.fragment_home.*
import org.xml.sax.InputSource
import java.io.File
import java.io.StringReader

class FlutterActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            val url = Intent(Intent.ACTION_VIEW)
            url.data = Uri.parse("https://flutter.dev/docs/get-started/install")
            startActivity(url)
        }

        scrollView.setOnScrollChangeListener { view, scrollX, scrollY,  oldScrollX, oldScrollY ->
            val percent : Float = scrollY.toFloat() / (linearLayout.height.toFloat() - 1539) * 100

            MainActivity.progressionViewModel.flutterProgression = "Flutter ${percent.toInt()}%"
        }
    }
}
