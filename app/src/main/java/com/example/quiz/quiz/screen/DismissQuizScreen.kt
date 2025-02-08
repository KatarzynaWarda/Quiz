package com.example.quiz.quiz.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.quiz.ui.theme.Purple1
import com.example.quiz.ui.theme.Purple3
import com.example.quiz.ui.theme.White

@Composable
fun DismissQuizScreen(
    openQuiz: () -> Unit,
    openGames: () -> Unit,
    onceAgain: String,
    goToMenu: String,
    summary: String,
    correct: Int,
    all: Int,
) {
    Dialog(
        onDismissRequest = openGames,
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = false)
    ) {
    Column(
        modifier = Modifier
            .defaultMinSize(minWidth = 300.dp, minHeight = 200.dp)
            .border(1.dp, Purple1, RoundedCornerShape(25.dp))
            .background(Purple3, RoundedCornerShape(25.dp))
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Question(
            summary = summary,
            correct = correct,
            all = all,
        )
        Row (
            modifier = Modifier.padding(top = 20.dp)
        ){
            AnswerButton(
                onClick = openQuiz,
                text = onceAgain,
            )
            AnswerButton(
                onClick = openGames,
                text = goToMenu,
            )
        }
        }
    }

}

@Composable
fun AnswerButton(
    onClick: () -> Unit,
    text: String,
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.titleSmall,
            color = Purple1,
        )
    }
}

@Composable
fun Question(
    summary: String,
    correct: Int,
    all: Int,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = summary,
            style = MaterialTheme.typography.headlineSmall,
            color = White
        )
        Text(
            text = "$correct/$all",
            style = MaterialTheme.typography.headlineLarge,
            color = White,
        )
    }
}

@Preview(
    device = "id:pixel_2",
  //  showSystemUi = true,
)
@Composable
private fun PreviewDismissQuizScreen() {
    DismissQuizScreen(
        {},
        {},
        onceAgain = "Zagraj jeszcze raz",
        goToMenu =  "Powrót do menu",
        summary = "Dobra robota!",
        correct = 2,
        all = 5,
    )
}