package com.example.quiz.quiz.uistate

data class DismissQuizUiState(
        val summary: String,
        val onceAgain: String,
        val goToMenu: String,
        val correct: Int,
        val all: Int,
    )
