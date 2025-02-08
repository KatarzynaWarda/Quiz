package com.example.quiz.games.module

import androidx.lifecycle.ViewModelProvider
import com.example.quiz.games.viewmodel.GamesViewModel
import dagger.Binds
import dagger.Module

@Module
abstract class GamesModule {

    @Binds
    abstract fun bindViewModelFactory(factory: GamesViewModel.Factory): ViewModelProvider.Factory
}