package com.example.quiz.games.uistate

data class DictionaryModel(
   val entryModel: MutableList<EntryModel>
)


data class EntryModel(
    val term: String,
    val definition: String,
)