package com.lpdam.SA.android_app.ui.home
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.lpdam.SA.android_app.FlutterActivity
import com.lpdam.SA.android_app.MainActivity
import com.lpdam.SA.android_app.R
import kotlinx.android.synthetic.main.fragment_home.*

open class HomeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        var progressionFlutterTextView = root.findViewById<View>(R.id.progressionFlutter) as TextView
        var progressionIonicTextView = root.findViewById<View>(R.id.progressionIonic) as TextView
        var progressionXamarinTextView = root.findViewById<View>(R.id.progressionXamarin) as TextView
        var progressionKotlinTextView = root.findViewById<View>(R.id.progressionKotlin) as TextView
        var progression_chart = root.findViewById<View>(R.id.progression_chart) as ProgressBar
        progressionFlutterTextView.text = MainActivity.progressionViewModel.flutterProgression
        progressionIonicTextView.text = MainActivity.progressionViewModel.ionicProgression
        progressionXamarinTextView.text = MainActivity.progressionViewModel.xamarinProgression
        progressionKotlinTextView.text = MainActivity.progressionViewModel.kotlinProgression
        progression_chart.progress = MainActivity.progressionViewModel.getTotalProgression()
        return root
    }
}


