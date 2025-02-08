package com.example.quiz.app.navigation

sealed class Screen(val route: String) {

    data object QuizScreen: Screen("quiz_screen")

    data object GamesScreen: Screen("games_screen")
}