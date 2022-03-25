package com.nokhyun.composeexam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.nokhyun.composeexam.ui.theme.BasicCodelabTheme

class ExamActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicCodelabTheme() {
                App()
            }

        }
    }

    @Composable
    private fun App(){
        Text(text = "Hello")
    }

    @Preview
    @Composable
    fun preview(){
        BasicCodelabTheme() {
            App()
        }
    }
}