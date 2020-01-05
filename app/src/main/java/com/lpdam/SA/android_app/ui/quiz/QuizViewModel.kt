package com.lpdam.SA.android_app.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Test your knowledge"
    }
    val text: LiveData<String> = _text

}