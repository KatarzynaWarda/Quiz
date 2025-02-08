package com.example.quiz.app.navigation

import android.app.Activity
import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorModule {

    @Binds
    abstract fun bindActivity(mainActivity: MainActivity): Activity

    @Binds
    abstract fun bindsNavigator(navigator: AppNavigator): Navigator
}