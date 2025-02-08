package com.example.quiz.app.navigation

sealed class Screen(val route: String) {

    data object QuizScreen: Screen("quiz_screen")

    data object GamesScreen: Screen("games_screen")

    data object MemoryScreen: Screen("memory_screen")

//    object FlashcardsScreen : Screen("flashcards_screen/{glossaryId}") {
//        fun createRoute(glossaryId: Int) = "flashcards_screen/$glossaryId"
//    }
}