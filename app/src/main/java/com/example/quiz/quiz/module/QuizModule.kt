package com.example.quiz.quiz.module

import androidx.lifecycle.ViewModelProvider
import com.example.quiz.quiz.usecase.GetCorrectAnswer
import com.example.quiz.quiz.usecase.GetCorrectAnswerUseCase
import com.example.quiz.quiz.usecase.GetDismissQuizUiState
import com.example.quiz.quiz.usecase.GetDismissQuizUiStateUseCase
import com.example.quiz.quiz.usecase.GetQuizzesData
import com.example.quiz.quiz.usecase.GetQuizzesDataUseCase
import com.example.quiz.quiz.viewmodel.QuizViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class QuizModule {

    @Binds
    abstract fun bindViewModelFactory(factory: QuizViewModel.Factory): ViewModelProvider.Factory

    @Binds
    internal abstract fun bindsGetCorrectAnswerUseCase(useCase: GetCorrectAnswer): GetCorrectAnswerUseCase

    @Binds
    internal abstract fun bindsGetQuizzesDataUseCase(useCase: GetQuizzesData): GetQuizzesDataUseCase

    @Binds
    internal abstract fun bindsGetDismissQuizUiStateUseCase(useCase: GetDismissQuizUiState): GetDismissQuizUiStateUseCase
}