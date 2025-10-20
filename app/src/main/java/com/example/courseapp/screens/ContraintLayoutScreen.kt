package com.example.courseapp.screens


/*  for every composable and elements in contraint layout we need to create the reference  */

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintLayoutBaseScope
import androidx.constraintlayout.compose.Dimension
import com.example.courseapp.R

@Composable
fun ConstraintLayoutScreen() {

    ConstraintLayout(                                                                               // Layout that positions its children according to the constraints between them.
                                                                                                    // Constraints are defined within the content of this ConstraintLayout Composable.
                                                                                                    // Items in the layout that are to be constrained are initialized with ConstraintLayoutScope.createRef as: val textRef = createRef()
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .verticalScroll(rememberScrollState())
    ) {

        // creating the references for composables that will be constrained within the layout

        val (gradientBackground, profileImg, notificationImg, welcomeText, jointBtn, questionText, coursesImg, myCard) = createRefs()

        /*    guideline : Lines to which other ConstrainedLayoutReferences may be constrained to,
              these are defined at either a fixed or percent position from an anchor of the ConstraintLayout parent (top, bottom, start, end, absoluteLeft, absoluteRight).      */

        val horizontalGuideline1 = createGuidelineFromTop(0.45f)

        BackgroundGradient(
            modifier = Modifier
                .constrainAs(gradientBackground) {
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
                    start.linkTo(parent.start)
                    bottom.linkTo(horizontalGuideline1)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints

                })

        // 1. Header : (chain example)
        val topGuideline = createGuidelineFromTop(34.dp)
        val startGuideline = createGuidelineFromStart(16.dp) // <-- FIX
        val endGuideline = createGuidelineFromEnd(16.dp)     // <-- FIX


        // 2. create chain

        createHorizontalChain(
            profileImg, notificationImg,
            chainStyle = ChainStyle.SpreadInside
        )

        ProfileImage(
            modifier = Modifier
                .constrainAs(profileImg) {
                    top.linkTo(topGuideline)
                }
        )

        NotificationImg(
            modifier = Modifier
                .constrainAs(notificationImg) {
                    top.linkTo(profileImg.top)
                    bottom.linkTo(profileImg.bottom)
                }
        )

         // 3. Middle part

        WelcomeText(
            modifier = Modifier
            .constrainAs(welcomeText){
                top.linkTo(profileImg.bottom, margin = 24.dp)
                start.linkTo(startGuideline)
            }
        )

        QuestionText(
            modifier = Modifier
                .constrainAs(questionText){
                    top.linkTo( welcomeText.bottom, margin = 8.dp)
                    start.linkTo(welcomeText.start)
                }
        )

        JoinButton(
            modifier = Modifier
                .constrainAs(jointBtn){
                top.linkTo(questionText.bottom, margin = 32.dp)
                    start.linkTo(questionText.start)
                    end.linkTo(questionText.end)
            }
        ){ /* due to lambda exp in parameter */  }

        CourseImage(
            modifier = Modifier
                .constrainAs(coursesImg){
                    bottom.linkTo(horizontalGuideline1, margin = 30.dp)
                    end.linkTo(endGuideline)
                    top.linkTo(jointBtn.bottom, margin = 0.dp)

                    width = Dimension.value(230.dp)
                   height = Dimension.fillToConstraints

                }
        )

        MyCard(
            modifier = Modifier
                .constrainAs(myCard){
                    top.linkTo(horizontalGuideline1, margin = (-28).dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)

                    width = Dimension.fillToConstraints
                    height = Dimension.fillToConstraints


                }
        )


    }
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