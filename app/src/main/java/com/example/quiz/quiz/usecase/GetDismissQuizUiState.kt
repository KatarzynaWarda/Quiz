package com.example.quiz.quiz.usecase

import com.example.quiz.quiz.uistate.DismissQuizUiState
import javax.inject.Inject

class GetDismissQuizUiState @Inject constructor() : GetDismissQuizUiStateUseCase {

    override operator fun invoke(
        correct: Int,
        all: Int,
    ): DismissQuizUiState =
        DismissQuizUiState(
            onceAgain = "Zagraj jeszcze raz",
            goToMenu = "Powrót do menu",
            summary = summary(correct = correct, all = all),
            correct = correct,
            all = all,
        )

    private fun summary(
        correct: Int,
        all: Int,
    ) =
        when (correct / all.toDouble()) {
            1.0 -> "Perfekcyjnie!"
            in 0.90..0.99 -> "Znakomicie!"
            in 0.75..0.89 -> "Świetny wynik!"
            in 0.50..0.74 -> "Dobra robota!"
            else -> "Próbuj dalej!"
        }
}