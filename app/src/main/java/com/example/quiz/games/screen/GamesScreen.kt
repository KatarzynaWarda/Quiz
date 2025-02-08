package com.example.quiz.games.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.games.uistate.GamesUiState
import com.example.quiz.ui.theme.Purple2
import com.example.quiz.ui.theme.Purple3
import com.example.quiz.ui.theme.Purple4
import com.example.quiz.ui.theme.White

@Composable
fun GamesScreen(
    openQuiz: () -> Unit,
    gamesUiState: GamesUiState,
) {
    ContentScreen(
        openQuiz = openQuiz,
        quizText = gamesUiState.quizText,
    )
}

@Composable
fun ContentScreen(
    openQuiz: () -> Unit,
    quizText: String,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple3)
    ) {
        Column(
            modifier = Modifier
                .padding(60.dp)
                .align(Alignment.TopCenter),
        ) {
            TextButton(
                onClick = openQuiz,
                modifier = Modifier
                    .fillMaxWidth()
                    .defaultMinSize(minHeight = 80.dp)
                    .padding(bottom = 20.dp)
                    .border(1.dp, Purple4, RoundedCornerShape(18.dp))
                    .background(Purple2, RoundedCornerShape(18.dp)),
            ) {
                Text(
                    text = quizText,
                    textAlign = TextAlign.Center,
                    color = White,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GamesPreview() {
    ContentScreen(
        openQuiz = {},
        quizText = "Quiz",
    )
}