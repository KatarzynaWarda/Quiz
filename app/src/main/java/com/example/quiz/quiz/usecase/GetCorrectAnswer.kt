package com.example.quiz.quiz.usecase

import com.example.quiz.quiz.uistate.QuizModel
import com.example.quiz.quiz.uistate.QuizUiState
import com.example.quiz.ui.theme.Purple2
import com.example.quiz.ui.theme.Purple4
import javax.inject.Inject

class GetCorrectAnswer @Inject constructor(
    private val getQuizzesDataUseCase: GetQuizzesDataUseCase,
) : GetCorrectAnswerUseCase {

    override suspend fun invoke(index: Int, points: Int) =
        getQuizzesDataUseCase().getOrElse(index) { getQuizzesDataUseCase().last() }
            .mapToState(index = minOf(index, getQuizzesDataUseCase().size), points)

    private fun QuizModel.mapToState(
        index: Int,
        points: Int,
        ) =
        QuizUiState.Content(
            question = question,
            answerA = answerA,
            answerB = answerB,
            answerC = answerC,
            answerD = answerD,
            properAnswer = properAnswer,
            buttonColor = Purple2,
            enable = true,
            borderColor = Purple4,
            index = index,
            points = points,
            showDialog = index == getQuizzesDataUseCase().size,
        )
}