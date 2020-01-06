package com.lpdam.SA.android_app.models

// Data class to parse JSON file
// Properties are the same as in the JSON file
data class Language(
    val name :String,
    val id: Int,
    val type: String,
    val description: String,
    val rating: String
)
