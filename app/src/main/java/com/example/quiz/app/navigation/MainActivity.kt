package com.example.quiz.app.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTagsAsResourceId
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quiz.games.screen.GamesScreen
import com.example.quiz.games.viewmodel.GamesViewModel
import com.example.quiz.memory.screen.MemoryScreen
import com.example.quiz.quiz.screen.QuizScreen
import com.example.quiz.quiz.uistate.QuizUiState
import com.example.quiz.quiz.viewmodel.QuizViewModel
import dagger.android.AndroidInjection
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

@OptIn(ExperimentalComposeUiApi::class)
class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var vmQuizFactory: QuizViewModel.Factory

    @Inject
    lateinit var vmGamesFactory: GamesViewModel.Factory

    companion object {
        const val START_DESTINATION = "start.destination"

        fun createIntent(context: Context, startDestination: Screen) =
            Intent(context, MainActivity::class.java).apply {
                putExtra(START_DESTINATION, startDestination.route)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val startDestination = intent?.getStringExtra(START_DESTINATION)
        setContent {
            val navController = rememberNavController()
            Surface(
                modifier = Modifier
                    .navigationBarsPadding()
                    .semantics { testTagsAsResourceId = true },
            ) {
                NavHost(navController = navController, startDestination = startDestination ?: Screen.GamesScreen.route) {
                    composable(Screen.GamesScreen.route) {
                        val vm: GamesViewModel by viewModels { vmGamesFactory }
                        val gamesUiState by vm.gamesUiState.collectAsState()
                        GamesScreen(
                            openQuiz = vm::openQuiz,
                            openMemory = vm::openMemory,
                            gamesUiState = gamesUiState
                        )
                    }
                    composable(Screen.QuizScreen.route) {
                        val vm: QuizViewModel by viewModels { vmQuizFactory }
                        val dismissDialogUiState = vm.dismissQuizUiState.collectAsState()
                        val quizUiState by vm.quizUiState.collectAsState()
                        QuizScreen(
                            dismissDialogUiState = dismissDialogUiState,
                            quizUiState = quizUiState,
                            closeButtonClick = { finish() },
                            buttonClick = { answer -> vm.onButtonClick(answer) },
                            openQuiz = vm::openQuiz,
                            openGames = vm::openGames,
                        )
                    }
                    composable(Screen.MemoryScreen.route) {
                        MemoryScreen(
                        )
                    }
                }
            }
        }
    }
}