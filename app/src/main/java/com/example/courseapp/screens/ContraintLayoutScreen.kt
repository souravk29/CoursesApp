package com.example.courseapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.courseapp.R

@Composable
fun ConstraintLayoutScreen() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
    ) {

        // creating the references for composables that will be constrained within the layout

        val (gradientBackground) = createRefs()

    }

}

@Composable
fun BackgroundGradient(){

    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Main Background",
        contentScale = ContentScale.FillBounds,

        modifier = Modifier.ConstrainAs                                                             // initially here the "ConstrainAs" will be shown as error becoz only
                                                                                                    // components defined inside the "ConstraintLayout" can benefit from
                                                                                                    // "ConstraintLayout" or "ConstrainAs"

                                                                                                    // this is the reason why we passed "modifier: Modifier" as parameter to this function
    )
}











/*

      ----------  val(gradientBackground) = createRefs()-------------


it creates a reference (like a unique ID or a handle) named gradientBackground that you can attach to a composable (like a Box or Image).
Once attached, you can use this reference to define layout constraints for other composables.

Here’s a simple breakdown:

1. The Function: createRefs()
This function creates one or more ConstrainedLayoutReference objects.

These are not UI components. They are just empty pointers that you will later assign to your actual composables.

2. The Syntax: val(gradientBackground) = ...
This is Kotlin's destructuring declaration. It's a clean way to "unpack" values from an object or function call.

The createRefs() function is designed to be destructured. You could just as easily create multiple references at once
*/