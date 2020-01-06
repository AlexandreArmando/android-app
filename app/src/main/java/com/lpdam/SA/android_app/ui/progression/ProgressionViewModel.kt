package com.lpdam.SA.android_app.ui.progression
/*
    Update the progression chart of the homepage and the %
 */
import androidx.lifecycle.ViewModel

class ProgressionViewModel : ViewModel() {
    var kotlinProgression: String = "Kotlin 0%"
    var ionicProgression: String = "Ionic 0%"
    var xamarinProgression: String = "Xamarin 0%"
    var flutterProgression: String = "Flutter 0%"

    fun getTotalProgression(): Int {
        var i = 0
        if(kotlinProgression == "Kotlin 100%"){
            i ++
        }
        if(ionicProgression == "Ionic 100%"){
            i ++
        }
        if(xamarinProgression == "Xamarin 100%"){
            i ++
        }
        if(flutterProgression == "Flutter 100%"){
            i ++
        }
        return i
    }
}