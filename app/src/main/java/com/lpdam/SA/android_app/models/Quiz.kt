package com.lpdam.SA.android_app.models

data class Quiz(
    val question :String,
    val answers: Array<String>,
    val correctAnswer: Array<String>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Quiz

        if (question != other.question) return false
        if (!answers.contentEquals(other.answers)) return false
        if (!correctAnswer.contentEquals(other.correctAnswer)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = question.hashCode()
        result = 31 * result + answers.contentHashCode()
        result = 31 * result + correctAnswer.contentHashCode()
        return result
    }
}
