package com.example.jetpackthemepicker.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * ThemeActivity -> lets users change the theme of the screen
 *
 * */

class ThemeActivity : ComponentActivity() {

    lateinit var appTheme: MutableState<AppThemeState>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = remember { SystemUiController(window) }
            appTheme = remember { mutableStateOf(AppThemeState()) }
            BaseView(appTheme.value, systemUiController) {
                ThemeSample()
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
    @Preview
    @Composable
    fun ThemeSample() {
        val spaceHeight = 24.dp
        Column(Modifier.background(MaterialTheme.colorScheme.background).fillMaxHeight()) {
            TopAppBar(
                title = { Text("Theme") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceTint
                ),
                navigationIcon = {
                    IconButton(onClick = { onBackPressed() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
            Column(Modifier.padding(20.dp)) {
                Text(text = "Change theme of this screen : ", style = MaterialTheme.typography.headlineMedium, color = MaterialTheme.colorScheme.surfaceTint)
                Spacer(Modifier.requiredHeight(spaceHeight))
                val colorPallet = ColorPalette.values()
                LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                    items(colorPallet.size, itemContent = {
                        val isSelected = colorPallet.get(it) == appTheme.value.pallet
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                Modifier
                                    .padding(20.dp)
                                    .size(100.dp)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(
                                        colorPallet
                                            .get(it)
                                            .getMaterialColor()
                                    )
                                    .clickable {
                                        appTheme.value = AppThemeState(false, colorPallet.get(it))
                                    }
                                    .then(
                                        if (isSelected) {
                                            Modifier.border(
                                                BorderStroke(2.dp, MaterialTheme.colorScheme.onSurface),
                                                shape = RoundedCornerShape(10.dp)
                                            )
                                        } else Modifier
                                    )
                            ) {
                                if (isSelected) {
                                    Icon(
                                        Icons.Filled.Check,
                                        contentDescription = "Theme Selected",
                                        modifier = Modifier
                                            .align(Alignment.Center)
                                            .size(40.dp),
                                        tint = Color.White
                                    )
                                }
                            }
                        }
                    })
                }
            }
        }
    }
}