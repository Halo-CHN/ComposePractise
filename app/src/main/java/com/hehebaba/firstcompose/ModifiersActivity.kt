package com.hehebaba.firstcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.hehebaba.firstcompose.ui.theme.FirstComposeTheme

class ModifiersActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var num by rememberSaveable {
                mutableStateOf(0)
            }
            ShowMoment {
                Toast.makeText(applicationContext, "onClick ${num++}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

val padding = 16.dp

@Composable
fun ShowMoment(onClick: () -> Unit) {
    val typography = MaterialTheme.typography
    Column(
        modifier = Modifier
            .padding(padding)
            .fillMaxWidth()
            .fillMaxHeight()
            .clickable(onClick = onClick)
            .verticalScroll(rememberScrollState())
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_child_care_24),
                contentDescription = "Avatar",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp)
            )
            Column() {
                Text(text = "Henry", style = typography.h6)
                Text(text = "1 hour ago", style = typography.body2)
            }
        }
        ___Spacer___()
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_5g_48),
            contentDescription = "It's 5G"
        )
        ___Spacer___()
        PaddingComposable()
        ___Spacer___()
        SizeComposable()
        ___Spacer___()
        FixedSizeComposable()
        ___Spacer___()
        FillSizeComposable()
        ___Spacer___()
        MatchParentSizeCompose()
        ___Spacer___()
        TextWithPaddingFromBaseline()
        ___Spacer___()
        OffsetComposable()
        ___Spacer___()
        FlexibleComposable()
        ___Spacer___()
        WithConstraintsComposable()
        ___Spacer___()
        ConstraintLayoutContent()
    }
}

@Composable
fun ___Spacer___() {
    Spacer(
        modifier = Modifier
            .size(padding)
            .background(Color.Blue)
    )
}

@Composable
fun ConstraintLayoutContent() {
    ConstraintLayout {
        // Create references for the composables to constrain
        val (button, text) = createRefs()

        Button(
            onClick = { /* Do something */ },
            // Assign reference "button" to the Button composable
            // and constrain it to the top of the ConstraintLayout
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
            }
        ) {
            Text("Button")
        }

        // Assign reference "text" to the Text composable
        // and constrain it to the bottom of the Button composable
        Text("Text", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 16.dp)
        })
    }
}

@Composable
fun WithConstraintsComposable() {
    BoxWithConstraints {
        Text("My minHeight is $minHeight while my maxWidth is $maxWidth")
    }
}

@Composable
fun FlexibleComposable() {
    Row(Modifier.width(210.dp)) {
        Box(
            Modifier
                .weight(2f)
                .height(50.dp)
                .background(Color.Green))
        Box(
            Modifier
                .weight(1f)
                .height(50.dp)
                .background(Color.Red))
    }
}

@Composable
fun OffsetComposable() {
    Box(
        Modifier
            .background(Color.Yellow)
            //.size(width = 150.dp, height = 70.dp)
    ) {
        Text(
            "Layout offset modifier sample",
            Modifier.offset(x = 2.dp, y = 2.dp)
        )
    }
}

@Composable
fun TextWithPaddingFromBaseline() {
    Box(Modifier.background(Color.Yellow)) {
        Text("Hi there!", Modifier.paddingFromBaseline(top = 32.dp))
    }
}

@Composable
fun MatchParentSizeCompose() {
    Box {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(Color.Green)
        )
        Text(text = "MatchParentSizeCompose")
    }
}

@Composable
fun FillSizeComposable() {
    Box(
        modifier = Modifier
            .background(Color.Green)
            .size(100.dp)
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .background(Color.Blue)
                .fillMaxSize()
        )
    }
}

@Composable
fun FixedSizeComposable() {
    Box(
        modifier = Modifier
            .size(90.dp, 150.dp)
            .background(Color.Green)
    ) {
        Box(
            Modifier
                .requiredSize(100.dp, 100.dp)
                .background(Color.Red)
        )
    }
}

@Composable
fun PaddingComposable() {
    Text(
        "Hello World", modifier = Modifier
            .background(Color.Green)
            .padding(20.dp)
    )
}

@Composable
fun SizeComposable() {
    Box(
        modifier = Modifier
            .size(100.dp, 100.dp)
            .background(Color.Red)
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    FirstComposeTheme {
        ShowMoment {

        }
    }
}