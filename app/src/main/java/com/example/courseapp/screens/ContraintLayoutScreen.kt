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

        val (gradientBackground, profileImg, notificationImg,
            welcomeText, jointBtn, questionText,
            coursesImg, myCard, textOurCourses, andDev,
            devOps, webDev, webt, andt, devt) = createRefs()                      //***   ONLY 16 SUCH REFERENCES CAN BE CREATED FROM 1 "createRefs()"

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
                    bottom.linkTo(horizontalGuideline1, margin = 10.dp)
                    end.linkTo(webt.end)
                    top.linkTo(jointBtn.bottom)

                    width = Dimension.value(300.dp)
                   height = Dimension.value(210.dp)

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

        TextOurCourses(
            modifier = Modifier
                .constrainAs(textOurCourses){
                top.linkTo(myCard.top, margin = 16.dp)
                start.linkTo(myCard.start, margin = 16.dp)
            }
        )

        AndroidCourse(
            modifier = Modifier.constrainAs(andDev){
                top.linkTo(textOurCourses.bottom, margin = 16.dp)
            }
        )

        DevOpsCourse(
            modifier = Modifier
                .constrainAs(devOps){
                    top.linkTo(andDev.top, margin = 16.dp)
                    bottom.linkTo(andDev.bottom, margin = 16.dp)
                }
        )

        WebDevCourse(
            modifier = Modifier
                .constrainAs(webDev){
                    top.linkTo(andDev.top, margin = 16.dp)
                    bottom.linkTo(andDev.bottom, margin = 16.dp)
                }
        )

        // chaining all three items
        createHorizontalChain(
            andDev, devOps, webDev,
            chainStyle = ChainStyle.Spread
        )

        WebText(
            modifier = Modifier
                .constrainAs(webt){
                    top.linkTo(webDev.bottom, margin =    5.dp)
                    start.linkTo(webDev.start)
                    end.linkTo(webDev.end)
                }
        )

        AndText(
            modifier = Modifier
                .constrainAs(andt){
                    top.linkTo(andDev.bottom, margin =     2.dp)
                    start.linkTo(andDev.start)
                    end.linkTo(andDev.end)
                }
        )

        DevText(
            modifier = Modifier
                .constrainAs(devt){
                    top.linkTo(devOps.bottom, margin =    5.dp)
                    start.linkTo(devOps.start)
                    end.linkTo(devOps.end)
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