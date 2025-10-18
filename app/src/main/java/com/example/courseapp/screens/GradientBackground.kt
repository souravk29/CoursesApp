package com.example.courseapp.screens

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import com.example.courseapp.R


@Composable
fun BackgroundGradient(modifier: Modifier){

    Image(
        painter = painterResource(id = R.drawable.bkgrd),
        contentDescription = "Main Background",
        contentScale = ContentScale.FillBounds,
        modifier = modifier.alpha(0.8f)                                                                         // if "modifier = Modifier.constarinAs" initially here the "constrainAs" will be shown as error becoz only
                                                                                                                        // components defined inside the "ConstraintLayout" can benefit from
                                                                                                                        // "ConstraintLayout" or "ConstrainAs", thats  why we used "modifier"
                                                                                                                        // instead of "Modifier" => not created new modifier but used the previosly defined one from the  ContraintLayout
                                                                                                                        // this is the reason why we passed "modifier: Modifier" as parameter to this function
    )
}