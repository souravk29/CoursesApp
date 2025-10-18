package com.example.courseapp.screens

import android.R.attr.start
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.courseapp.R

@Composable
fun ProfileImage(modifier: Modifier){

    Image(
        painter = painterResource(id = R.drawable.outline_contacts_product_24),
        contentDescription = "Profile",
        modifier = modifier
            .padding(start = 16.dp)
            .clip(CircleShape)
            .size(40.dp)
        )
}

@Composable
fun NotificationImg(modifier: Modifier){

        Image(
            painter = painterResource(id = R.drawable.outline_circle_notifications_24),
            contentDescription = "Profile",
            modifier = modifier
                .padding(end = 16.dp)
                .clip(CircleShape)
                .size(40.dp)
        )
}