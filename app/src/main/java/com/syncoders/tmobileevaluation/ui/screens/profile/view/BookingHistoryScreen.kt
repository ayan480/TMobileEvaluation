package com.syncoders.tmobileevaluation.ui.screens.profile.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorPrimary
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.common_components.CurveHeader


@Composable
fun BookingHistoryScreen(navController: NavHostController) {
    val items = listOf(
        "Parcel #1" to listOf("Order Received", "In Transit", "Delivered"),
        "Parcel #2" to listOf("Order Received", "In Transit", "Delivered")
    )

    Scaffold(
        topBar = { CurveHeader("Booking History") }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            items(items) { (header, subItems) ->
                ExpandableSection(header, subItems)
            }
        }
    }
}

@Composable
fun ExpandableSection(header: String, subItems: List<String>) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Transparent, shape = RoundedCornerShape(8.dp)) // Green background
            .clickable { isExpanded = !isExpanded }
            .padding(12.dp) // Adjusted padding
    ) {
        // Header
        Box (modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF5A9EAB).copy(alpha = 0.5f)) // Add your desired background color
            .padding(12.dp) ){
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = header,
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = ColorPrimary,
                        fontSize = 20.sp // Larger header text size
                    ),
                    modifier = Modifier.weight(1f)
                )
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = null,
                    tint = ColorPrimary, // White icon color
                    modifier = Modifier.size(24.dp)
                )
            }
        }


        if (isExpanded) {
            Column {
                Text(
                    text = "Shipping Details",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Black,
                        fontSize = 18.sp
                    ),
                    modifier = Modifier.weight(1f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(modifier = Modifier.padding(top = 8.dp)) {
                    subItems.forEachIndexed { index, item ->
                        StepItemRow(
                            text = item,
                            isLast = index == subItems.lastIndex
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StepItemRow(text: String, isLast: Boolean) {
    Row(modifier = Modifier.fillMaxWidth()) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(start = 16.dp, end = 8.dp)
        ) {

            Icon(
                imageVector = if (text == "Delivered") Icons.Default.Circle else Icons.Default.CheckCircle ,
                contentDescription = null,
                tint =  Orange ,
                modifier = Modifier.size(32.dp)
            )


            if (!isLast) {
                Box(
                    modifier = Modifier
                        .width(2.dp)
                        .height(36.dp)
                        .background(Orange)
                )
            }
        }

        // Step text
        Column(modifier = Modifier.padding(vertical = 8.dp)) {
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "This is the description for the order.",
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.W400,
                    fontSize = 12.sp
                )
            )
        }
    }
}

