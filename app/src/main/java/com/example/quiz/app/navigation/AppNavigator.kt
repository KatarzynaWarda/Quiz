package com.example.quiz.app.navigation

import android.app.Activity
import java.lang.ref.WeakReference
import javax.inject.Inject

class AppNavigator @Inject constructor(
    private val activity: Activity,
): Navigator {

    private val weakActivity: WeakReference<Activity> = WeakReference(activity)

    override fun openQuiz() {
        getContext()?.let {
            it.startActivity(MainActivity.createIntent(it, Screen.QuizScreen))
        }
    }

    override fun openGames() {
        getContext()?.let {
            it.startActivity(MainActivity.createIntent(it, Screen.GamesScreen))
        }
    }

    override fun openMemory() {
        getContext()?.let {
            it.startActivity(MainActivity.createIntent(it, Screen.MemoryScreen))
        }
    }

    private fun getContext() = weakActivity.get()
}