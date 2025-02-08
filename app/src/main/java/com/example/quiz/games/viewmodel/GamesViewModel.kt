package com.example.quiz.games.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quiz.app.navigation.Navigator
import com.example.quiz.games.uistate.GamesUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class GamesViewModel @Inject constructor(
    private val navigator: Navigator,
) : ViewModel() {

    private val _gamesUiState = MutableStateFlow(GamesUiState("Quiz", "Memory"))
    val gamesUiState = _gamesUiState.asStateFlow()

    fun openQuiz() = navigator.openQuiz()

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val navigator: Navigator,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            if (modelClass.isAssignableFrom(GamesViewModel::class.java)) {
                return GamesViewModel(
                    navigator = navigator
                ) as T
            }

            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}