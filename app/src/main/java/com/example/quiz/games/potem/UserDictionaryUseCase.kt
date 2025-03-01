package com.example.quiz.games.potem

import com.example.quiz.games.uistate.DictionaryModel

interface UserDictionaryUseCase {

    operator fun invoke(): DictionaryModel
}