package com.example.quiz.quiz.usecase

import com.example.quiz.quiz.uistate.QuizUiState

interface GetCorrectAnswerUseCase {

    suspend operator fun invoke(index: Int, points: Int): QuizUiState
}