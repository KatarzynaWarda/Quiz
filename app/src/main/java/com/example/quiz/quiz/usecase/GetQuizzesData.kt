package com.example.quiz.quiz.usecase

import com.example.quiz.games.potem.UserDictionaryUseCase
import com.example.quiz.quiz.uistate.QuizModel
import javax.inject.Inject

class GetQuizzesData @Inject constructor(
    private val userDictionaryUseCase: UserDictionaryUseCase,
) : GetQuizzesDataUseCase {
    private val quizData = getQuizQuestions(userDictionaryUseCase)

    override fun invoke(): List<QuizModel> = quizzesList()

    private fun quizzesList(): List<QuizModel> {

        return quizData.map { quiz ->
            QuizModel(
                question = quiz.first,
                answerA = quiz.second[0],
                answerB = quiz.second[1],
                answerC = quiz.second[2],
                answerD = quiz.second[3],
                properAnswer = quiz.third,
            )
        }
    }

    private fun getQuizQuestions(
        countriesAndCapitals: UserDictionaryUseCase,
    ): List<Triple<String, List<String>, String>> {

        val selectedCountries = countriesAndCapitals().entryModel.shuffled()

        return selectedCountries.map { correctPair ->
            val correctCountry = correctPair.term
            val correctCapital = correctPair.definition

            val incorrectCapitals = selectedCountries
                .filter { it.definition != correctCapital }
                .shuffled()
                .take(3)
                .map { it.definition }

            val answers = (incorrectCapitals + correctCapital).shuffled()

            Triple(correctCountry, answers, correctCapital)
        }
    }
}
