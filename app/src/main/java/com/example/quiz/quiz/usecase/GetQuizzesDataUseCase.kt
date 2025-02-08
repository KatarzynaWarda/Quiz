package com.example.quiz.quiz.usecase

import com.example.quiz.quiz.uistate.QuizModel

interface GetQuizzesDataUseCase {

    operator fun invoke(): List<QuizModel>
}