package com.syncoders.tmobileevaluation.ui.screens.profile.view

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TabRowDefaults.Divider

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.R
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.common_components.CurveHeader
import com.syncoders.tmobileevaluation.ui.screens.profile.view.components.TravelModeCard


@Composable
fun HistoryListScreen(navHostController: NavHostController) {
    var selectedTopButton by remember { mutableStateOf("Small") }
    var selectedBottomButton by remember { mutableStateOf("Lorem") }

    Scaffold(
        topBar = {
            CurveHeader("Booking History")
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "All bookings",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Black
                ),
            )

            // Top row of buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf("Small", "Medium", "Large").forEach { size ->
                    Button(
                        onClick = { selectedTopButton = size },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedTopButton == size) Orange else Color.Transparent,
                            contentColor = if (selectedTopButton == size) Color.White else Orange
                        ),
                        border = if (selectedTopButton != size) BorderStroke(1.dp, Orange) else null
                    ) {
                        Text(text = size, style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
                    }
                }
            }

            // Middle list (LazyColumn)
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp)
            ) {
                items(15) { index ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Text(
                            text = "This is Title $index",
                            style = TextStyle(
                                fontWeight = FontWeight.W600,
                                fontSize = 14.sp,
                            ),
                            color = Color.Gray
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Description for item $index. This is a detailed description.",
                            style = TextStyle(
                                fontWeight = FontWeight.W800,
                                fontSize = 18.sp,
                            ),
                            color = Black,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    Divider(color = Color.LightGray, thickness = 1.dp)
                }
            }

            // Bottom row of buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                listOf("Lorem", "Ipsum").forEach { label ->
                    Button(
                        onClick = { selectedBottomButton = label },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (selectedBottomButton == label) Orange else Color.Transparent,
                            contentColor = if (selectedBottomButton == label) Color.White else Orange
                        ),
                        border = if (selectedBottomButton != label) BorderStroke(1.dp, Orange) else null
                    ) {
                        Text(text = label,style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
                    }
                }
            }
        }
    }
}
