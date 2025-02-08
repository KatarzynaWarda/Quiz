package com.example.quiz.quiz.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quiz.ui.theme.Green1
import com.example.quiz.ui.theme.Green2
import com.example.quiz.ui.theme.Purple2
import com.example.quiz.ui.theme.Purple4
import com.example.quiz.ui.theme.White

@Composable
fun AnswerButton(
    onClick: () -> Unit,
    enabled: Boolean,
    answerText: String,
    clickedAnswer: String?,
    buttonColor: Color,
    borderColor: Color,
) {
    val isClicked = clickedAnswer == answerText
    TextButton(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 80.dp)
            .padding(top = 20.dp)
            .border(1.dp, if (isClicked) borderColor else Purple2, RoundedCornerShape(18.dp))
            .background(if (isClicked) buttonColor else Purple2, RoundedCornerShape(18.dp)),
        enabled = enabled,
    ) {
        Text(
            text = answerText,
            textAlign = TextAlign.Center,
            color = White,
        )
    }
}

@Preview
@Composable
fun Preview() {
    AnswerButton(
        onClick = {},
        clickedAnswer = "Warszawa",
        answerText = "Warszawa",
        buttonColor = Green2,
        enabled = true,
        borderColor = Green1,
    )
}