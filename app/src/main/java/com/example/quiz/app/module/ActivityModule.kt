package com.example.quiz.app.module

import com.example.quiz.app.navigation.MainActivity
import com.example.quiz.app.navigation.NavigatorModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(
        modules = [
            NavigatorModule::class,
        ]
    )
    abstract fun contributeDownloadsActivity(): MainActivity
}