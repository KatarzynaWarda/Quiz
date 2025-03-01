package com.example.quiz.games.potem

import com.example.quiz.games.uistate.DictionaryModel
import com.example.quiz.games.uistate.EntryModel
import javax.inject.Inject

class UserDictionary @Inject constructor(): UserDictionaryUseCase {

    override fun invoke() =
        DictionaryModel(
            mutableListOf(
                EntryModel("Polska", "Warszawa"),
                EntryModel("Niemcy", "Berlin"),
                EntryModel("Ukraina", "Kijów"),
                EntryModel("Białoruś", "Mińsk"),
                EntryModel("Francja", "Paryż"),
            )
        )
}