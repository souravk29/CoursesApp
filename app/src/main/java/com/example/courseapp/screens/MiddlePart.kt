package com.example.courseapp.screens

import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.courseapp.R


@Composable
fun WelcomeText(modifier: Modifier){

    Text(
        text = "Welcome Back",
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        modifier = modifier
        )
}

@Composable
fun QuestionText(modifier: Modifier){

    Text(
        text = "What do you want to learn ?",
        color = Color.Black,
        modifier = modifier
    )
}

@Composable
fun JoinButton( modifier: Modifier, onClick: ()-> Unit ){

    Button(
        onClick = { onClick() },
        modifier = modifier
    ) {
        Text(text = "Join Now")
    }
}

@Composable
fun CourseImage(modifier: Modifier){

    Image(
        painter = painterResource(id = R.drawable.p25),
        contentDescription = "Courses",
        modifier = modifier

    )
}