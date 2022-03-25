package com.nokhyun.composeexam

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.nokhyun.composeexam.ui.theme.BasicCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme {
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.background) {
                Surface(color = Color(ContextCompat.getColor(this, R.color.white))) {
                    //                    Greeting("Android")
                    MyApp()
                }
            }
        }
    }


    @Composable
    fun Greeting(name: String) {
//        var expanded by remember {
//            mutableStateOf(false)
//        }
////        val extraPadding = if(expanded) 48.dp else 0.dp
//        val extraPadding by animateDpAsState(
//            if (expanded) 48.dp else 0.dp,
//            animationSpec = spring(
//                dampingRatio = Spring.DampingRatioMediumBouncy,
//                stiffness = Spring.StiffnessLow
//            )
//        )
//
//        log("Greeting: $expanded")
//        androidx.compose.material.Surface(
//            color = MaterialTheme.colors.primary,
//            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
//        ) {
//            Row(modifier = Modifier.padding(24.dp)) {
//                Column(
//                    modifier = Modifier
//                        .weight(1f)
//                        .padding(bottom = extraPadding.coerceAtLeast(0.dp))
//                ) {
//                    Text(text = "Hello, ")
//                    Text(
//                        name, style = MaterialTheme.typography.h4.copy(
//                            fontWeight = FontWeight.ExtraBold
//                        )
//                    )
//                }
//
//                OutlinedButton(modifier = Modifier
//                    .weight(1f), onClick = {
//                    log("onClick")
//                    expanded = !expanded
//
//                }) {
//                    Text(if (expanded) "Show less" else "Show more")
//                }
//
//            }
//        }

        Card(
            backgroundColor = MaterialTheme.colors.primary,
            modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
        ) {
            CardContent(name = name)
        }
    }

    @Composable
    fun TextFieldTest() {
        TextField(value = "textField", onValueChange = {
            log("TextFiled on")
        })
    }

    @Preview(showBackground = true, widthDp = 320)
    @Composable
    fun DefaultPreview() {
        BasicCodelabTheme {
//        Greeting("Android")
            MyApp()
        }
    }

    @Composable
    private fun MyApp(names: List<String> = listOf("World", "Compose")) {
        var shouldShowOnboarding by rememberSaveable { mutableStateOf(true) }
        log("MyApp")
        if (shouldShowOnboarding) {
            OnboardingScreen(onContinueClicked = { shouldShowOnboarding = false })
        } else {
            Greetings()
        }
    }

    @Composable
    private fun Greetings(names: List<String> = List(1000) { "$it" }) {
//        Column(modifier = Modifier.padding(vertical = 4.dp)) {
//            for (name in names) {
//                Greeting(name = name)
//            }
//        }

        LazyColumn(modifier = Modifier.padding(4.dp)) {
            items(items = names) { name ->
                Greeting(name = name)
            }
        }
    }


    private fun log(msg: String) {
        Log.e("test", msg)
    }

    @Composable
    fun OnboardingScreen(onContinueClicked: () -> Unit) {

        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Wealcome to the Basics Codelab!")
                Button(
                    modifier = Modifier.padding(vertical = 24.dp),
                    onClick = onContinueClicked
//                    onClick = {startActivity(Intent(this@MainActivity, ExamActivity::class.java))}
                ) {
                    Text("Continue")
                }
            }
        }
    }

    @Preview(
        showBackground = true,
        widthDp = 320,
        uiMode = UI_MODE_NIGHT_YES,
        name = "DefaultPreviewDark"
    )
    @Preview(showBackground = true, widthDp = 320, heightDp = 320)
    @Composable
    fun OnboardingPreview() {
        BasicCodelabTheme {
            OnboardingScreen(onContinueClicked = {})
        }
    }

    @Composable
    private fun CardContent(name: String) {
        var expanded by remember { mutableStateOf(false) }

        Row(
            modifier = Modifier
                .padding(12.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = {
                        log("Icon click!!")
                        expanded = !expanded
                    }),
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(12.dp)
            ) {
                Text(text = "Hello, ")
                Text(
                    text = name,
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                if (expanded) {
                    Text(
                        text = ("Composem ipsum color sit lazy. padding theme elit, sed do bouncy").repeat(4)
                    )
                }
            }

//            IconButton(
//                onClick = {
//                    log("IconButton click!!")
//                    expanded = !expanded
//                }
//            ) {
            Icon(
//                    modifier = Modifier.clickable(
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = null,
//                        onClick = {
//                            log("Icon click!!")
//                            expanded = !expanded
//                        }),
                imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                contentDescription = if (expanded) {
                    stringResource(id = R.string.show_less)
                } else {
                    stringResource(id = R.string.show_more)
                }
            )
//            }
        }
    }
}
