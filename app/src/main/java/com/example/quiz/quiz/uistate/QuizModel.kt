package com.example.quiz.quiz.uistate

data class QuizModel(
    val question: String,
    val answerA: String,
    val answerB: String,
    val answerC: String,
    val answerD: String,
    val properAnswer: String,
)