package com.example.jetpackthemepicker // Replace the package name with yours

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackthemepicker.model.Component
import com.example.jetpackthemepicker.ui.theme.AppThemeState
import com.example.jetpackthemepicker.ui.theme.BaseView
import com.example.jetpackthemepicker.ui.theme.SystemUiController
import com.example.jetpackthemepicker.ui.theme.ThemeActivity

/**
 * This screen defines the entire navigation flow of activities and the home screen UI
 * */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = remember { SystemUiController(window) }
            val appTheme = remember { mutableStateOf(AppThemeState()) }
            BaseView(appTheme.value, systemUiController) {
                MainScreen()
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun MainScreen() {
        Column(Modifier.background(MaterialTheme.colorScheme.background)) {
            TopAppBar(
                title = { Text(text = "Jetpack theme picker", color = Color.Black) },
            )
            LazyColumn {
                items(getComponents()) {
                    ButtonComponent(it.componentName, it.className)
                }
            }
        }
    }

    @Composable
    fun ButtonComponent(buttonText: String, className: Class<*>) {
        val context = LocalContext.current
        OutlinedButton(
            onClick = {
                context.startActivity(Intent(applicationContext, className))
            },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary.copy(0.04f)),
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.primary.copy(0.5f)),
        ) {
            Text(
                modifier = Modifier
                    .padding(8.dp),
                text = buttonText,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }

    private fun getComponents() = listOf(
        Component("Theme", ThemeActivity::class.java),
    )

}