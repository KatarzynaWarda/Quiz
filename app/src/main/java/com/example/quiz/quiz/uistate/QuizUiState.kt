package com.example.quiz.quiz.uistate

import androidx.compose.ui.graphics.Color

sealed interface QuizUiState {

    data class Content(
        val question: String,
        val answerA: String,
        val answerB: String,
        val answerC: String,
        val answerD: String,
        val properAnswer: String,
        val clickedAnswer: String? = null,
        val buttonColor: Color,
        val enable: Boolean,
        val borderColor: Color,
        val index: Int,
        val points: Int = 0  ,
        val showDialog: Boolean,
    ) : QuizUiState

    data object Loading : QuizUiState
}