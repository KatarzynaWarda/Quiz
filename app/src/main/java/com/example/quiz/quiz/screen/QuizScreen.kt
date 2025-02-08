package com.example.quiz.quiz.screen

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.quiz.R
import com.example.quiz.quiz.uistate.DismissQuizUiState
import com.example.quiz.quiz.uistate.QuizUiState
import com.example.quiz.ui.theme.Gray2
import com.example.quiz.ui.theme.Purple3
import com.example.quiz.ui.theme.Purple4
import com.example.quiz.ui.theme.White

@Composable
fun QuizScreen(
    dismissDialogUiState: State<DismissQuizUiState>,
    quizUiState: QuizUiState,
    closeButtonClick: () -> Unit,
    buttonClick: (String) -> Unit,
    openQuiz: () -> Unit,
    openGames: () -> Unit,
) {
    when (quizUiState) {
        is QuizUiState.Content -> {
            ContentScreen(
                question = quizUiState.question,
                answerA = quizUiState.answerA,
                answerB = quizUiState.answerB,
                answerC = quizUiState.answerC,
                answerD = quizUiState.answerD,
                closeButton = closeButtonClick,
                buttonClick = buttonClick,
                buttonColor = quizUiState.buttonColor,
                clickedAnswer = quizUiState.clickedAnswer,
                enabled = quizUiState.enable,
                borderColor = quizUiState.borderColor,
            )

            if (quizUiState.showDialog) {
                DismissQuizScreen(
                    openQuiz = openQuiz,
                    openGames = openGames,
                    onceAgain = dismissDialogUiState.value.onceAgain,
                    goToMenu = dismissDialogUiState.value.goToMenu,
                    summary = dismissDialogUiState.value.summary,
                    correct = dismissDialogUiState.value.correct,
                    all = dismissDialogUiState.value.all,
                )
            }
        }
        is QuizUiState.Loading -> {
            Box(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun ContentScreen(
    question: String,
    answerA: String,
    answerB: String,
    answerC: String,
    answerD: String,
    clickedAnswer: String?,
    closeButton: () -> Unit,
    buttonClick: (String) -> Unit,
    buttonColor: Color,
    borderColor: Color,
    enabled: Boolean,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple3)
            .padding(vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = closeButton,
            modifier = Modifier
                .padding(start = 30.dp)
                .align(Alignment.Start),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_close),
                tint = White,
                contentDescription = "close"
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 240.dp)
                .padding(horizontal = 40.dp)
                .background(Purple4, RoundedCornerShape(18.dp))
                .border(3.dp, Gray2, shape = RoundedCornerShape(18.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = question,
                color = White,
                style = MaterialTheme.typography.titleLarge,
            )
        }
        Column(
            modifier = Modifier
                .verticalScroll(ScrollState(0))
                .padding(horizontal = 40.dp)
        ) {
            AnswerButton(
                onClick = { buttonClick(answerA) },
                enabled = enabled,
                answerText = answerA,
                clickedAnswer = clickedAnswer,
                buttonColor = buttonColor,
                borderColor = borderColor,
            )
            AnswerButton(
                onClick = { buttonClick(answerB) },
                enabled = enabled,
                answerText = answerB,
                clickedAnswer = clickedAnswer,
                buttonColor = buttonColor,
                borderColor = borderColor,
            )
            AnswerButton(
                onClick = { buttonClick(answerC) },
                enabled = enabled,
                answerText = answerC,
                clickedAnswer = clickedAnswer,
                buttonColor = buttonColor,
                borderColor = borderColor,
            )
            AnswerButton(
                onClick = { buttonClick(answerD) },
                enabled = enabled,
                answerText = answerD,
                clickedAnswer = clickedAnswer,
                buttonColor = buttonColor,
                borderColor = borderColor,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

//@Preview(device = "id:pixel_2")
//@Composable
//fun GreetingPreview() {
//    ContentScreen(
//        question = "Polska",
//        answerA = "Mińsk  \n nvaeon on oneo \n [n[ oner [no n[ \n nogo[g nareno \n [ [iokm",
//        answerB = "Berlin \n nvaeon on \n oneo [n[ \noner [no n[ nogo[g v\nnareno [ [iokm",
//        answerC = "Warszawa \nnvaeon \non oneo \n[n[ oner \n[no n[ no\ngo[g nareno [\n [iokm",
//        answerD = "Kijów nvaeo\nn on oneo\n [n[ oner \n[no n[ \nnogo[g na\nreno [ [iokm",
//        answerText = "",
//        closeButton = {},
//        buttonClick = {},
//        buttonColor = Green2,
//        enabled = true,
//        borderColor = Green1,
//    )
//}