package com.example.courseapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapp.R


@Composable
fun TextOurCourses(modifier: Modifier){

    Text(
        text = "New Courses",
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier,
        color = Color.Black
    )

}

@Composable
fun AndroidCourse(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.p31),
        contentDescription = "Android Development",
        modifier = modifier.size(122.dp)
    )
}


@Composable
fun DevOpsCourse(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.p3),
        contentDescription = "DevOps",
        modifier = modifier.size(115.dp)
    )
}


@Composable
fun WebDevCourse(modifier: Modifier){
    Image(
        painter = painterResource(id = R.drawable.p32),
        contentDescription = "Web Development",
        modifier = modifier.size(115.dp)
    )
}

@Composable
fun AndText(modifier: Modifier){
    Text(
        text = "Android Dev",
        fontSize = 16.sp,
        modifier = modifier
    )
}


@Composable
fun DevText(modifier: Modifier){
    Text(
        text = "DevOps",
        fontSize = 16.sp,
        modifier = modifier
    )
}

@Composable
fun WebText(modifier: Modifier){
    Text(
        text = "Website Dev",
        fontSize = 16.sp,
        modifier = modifier
    )
}