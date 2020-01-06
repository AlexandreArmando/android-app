package com.lpdam.SA.android_app

import android.graphics.Typeface
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.lpdam.SA.android_app.models.Language
import com.lpdam.SA.android_app.ui.progression.ProgressionViewModel
import kotlinx.android.synthetic.main.fragment_dashboard.*
import java.io.IOException
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var progressionViewModel: ProgressionViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        progressionViewModel = ViewModelProviders.of(this).get(ProgressionViewModel::class.java)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_quiz
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

}
