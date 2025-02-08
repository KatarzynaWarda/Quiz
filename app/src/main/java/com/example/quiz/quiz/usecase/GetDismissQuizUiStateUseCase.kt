package com.example.quiz.quiz.usecase

import com.example.quiz.quiz.uistate.DismissQuizUiState

interface GetDismissQuizUiStateUseCase {

    operator fun invoke(
        correct: Int,
        all: Int,
    ): DismissQuizUiState
}