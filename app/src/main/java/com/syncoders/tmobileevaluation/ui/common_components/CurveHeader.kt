package com.syncoders.tmobileevaluation.ui.common_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.syncoders.tmobileevaluation.presentation.ui.theme.ColorPrimary

@Composable
fun CurveHeader(title: String){
    Box(
        Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(0.dp)
            .background(ColorPrimary)
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(modifier = Modifier.padding(top = 36.dp),text= title, style = MaterialTheme.typography.headlineSmall.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.White
            ))
            Spacer(modifier = Modifier.weight(1.0f))
            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .background(ColorPrimary)
            ) {

                val canvasWidth = size.width
                val canvasHeight = size.height
                val arcHeight = 100f

                drawArc(
                    color =  Color.White,
                    startAngle = 0f,
                    sweepAngle = -180f,
                    useCenter = false,
                    topLeft = Offset(0f, canvasHeight - arcHeight / 2), // Place at the bottom

                    // topLeft = Offset(0f, arcHeight * 3),
                    size = Size(canvasWidth, arcHeight)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CurvePreview() {
    CurveHeader("hiii")
}