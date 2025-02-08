package com.example.quiz.app.module

import com.example.quiz.app.MyApplication
import com.example.quiz.app.navigation.NavigatorModule
import com.example.quiz.games.module.GamesModule
import com.example.quiz.quiz.module.QuizModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        QuizModule::class,
        ActivityModule::class,
        GamesModule::class,
    ]
)
interface AppComponent : AndroidInjector<MyApplication> {

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: MyApplication,
        ): AppComponent
    }
}