package com.example.quiz.quiz.usecase

import com.example.quiz.quiz.uistate.QuizModel
import javax.inject.Inject

class GetQuizzesData @Inject constructor() : GetQuizzesDataUseCase {

    override fun invoke() = quizzesList

    private val quizzesList = listOf(
        QuizModel(
            question = "Polska",
            answerA = "Mińsk",
            answerB = "Berlin",
            answerC = "Warszawa",
            answerD = "Kijów",
            properAnswer = "Warszawa",
        ),
        QuizModel(
            question = "Niemcy",
            answerA = "Warszawa",
            answerB = "Mińsk",
            answerC = "Paryż",
            answerD = "Berlin",
            properAnswer = "Berlin",
        ),
        QuizModel(
            question = "Ukraina",
            answerA = "Paryż",
            answerB = "Kijów",
            answerC = "Berlin",
            answerD = "Warszawa",
            properAnswer = "Kijów",
        ),
        QuizModel(
            question = "Białoruś",
            answerA = "Mińsk",
            answerB = "Paryż",
            answerC = "Berlin",
            answerD = "Warszawa",
            properAnswer = "Mińsk",
        ),
        QuizModel(
            question = "Francja",
            answerA = "Mińsk",
            answerB = "Warszawa",
            answerC = "Paryż",
            answerD = "Kijów",
            properAnswer = "Paryż",
        ),
    )
}