package com.example.quiz.quiz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.quiz.app.navigation.Navigator
import com.example.quiz.quiz.uistate.QuizUiState
import com.example.quiz.quiz.usecase.GetCorrectAnswerUseCase
import com.example.quiz.quiz.usecase.GetDismissQuizUiState
import com.example.quiz.ui.theme.Green1
import com.example.quiz.ui.theme.Green2
import com.example.quiz.ui.theme.Red1
import com.example.quiz.ui.theme.Red2
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

class QuizViewModel @Inject constructor(
    private val getCorrectAnswerUseCase: GetCorrectAnswerUseCase,
    private val getDismissQuizUiState: GetDismissQuizUiState,
    private val navigator: Navigator,
    @Named("IO") private val ioContext: CoroutineDispatcher,
) : ViewModel() {

    private val _quizUiState = MutableStateFlow<QuizUiState>(QuizUiState.Loading)
    val quizUiState = _quizUiState.asStateFlow()

    private val _dismissQuizUiState = MutableStateFlow(getDismissQuizUiState(0, 0))
    val dismissQuizUiState = _dismissQuizUiState.asStateFlow()

    init {
        initUiState()
    }

    fun openQuiz() = navigator.openQuiz()

    fun openGames() = navigator.openGames()

    fun onButtonClick(clickedAnswer: String?) {
        val state = quizUiState.value as QuizUiState.Content
        viewModelScope.launch(ioContext) {
            _quizUiState.update {
                state.copy(
                    buttonColor = if (clickedAnswer != state.properAnswer) Red2 else Green2,
                    enable = true,
                    borderColor = if (clickedAnswer != state.properAnswer) Red1 else Green1,
                    clickedAnswer = clickedAnswer,
                )
            }
            delay(2000)
            val newData = getCorrectAnswerUseCase(
                index = state.index + 1,
                points = if (clickedAnswer == state.properAnswer) state.points+1 else state.points,
            )
            _quizUiState.update { newData }
            _dismissQuizUiState.update { getDismissQuizUiState(
                (quizUiState.value as QuizUiState.Content).points,
                (quizUiState.value as QuizUiState.Content).index,
            )
            }
        }
    }

    private fun initUiState() =
        viewModelScope.launch(ioContext) {
            val data = getCorrectAnswerUseCase(
                index = 0,
                points = 0,
            )
            _quizUiState.update { data }
        }

    @Suppress("UNCHECKED_CAST")
    class Factory @Inject constructor(
        private val getCorrectAnswerUseCase: GetCorrectAnswerUseCase,
        private val getDismissQuizUiState: GetDismissQuizUiState,
        private val navigator: Navigator,
        @Named("IO") private val ioContext: CoroutineDispatcher,
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            if (modelClass.isAssignableFrom(QuizViewModel::class.java)) {
                return QuizViewModel(
                    getCorrectAnswerUseCase = getCorrectAnswerUseCase,
                    getDismissQuizUiState = getDismissQuizUiState,
                    navigator = navigator,
                    ioContext = ioContext,
                ) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}