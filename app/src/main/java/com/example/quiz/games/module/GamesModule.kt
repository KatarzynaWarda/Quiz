package com.example.quiz.games.module

import androidx.lifecycle.ViewModelProvider
import com.example.quiz.games.potem.UserDictionary
import com.example.quiz.games.potem.UserDictionaryUseCase
import com.example.quiz.games.viewmodel.GamesViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class GamesModule {

    @Binds
    abstract fun bindViewModelFactory(factory: GamesViewModel.Factory): ViewModelProvider.Factory

    @Binds
    internal abstract fun userDictionaryUseCase(useCase: UserDictionary): UserDictionaryUseCase
}