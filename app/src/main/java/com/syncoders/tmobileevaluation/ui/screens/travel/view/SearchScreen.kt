package com.syncoders.tmobileevaluation.ui.screens.travel.view

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TabRowDefaults.Divider

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddLocation
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.syncoders.tmobileevaluation.R
import com.syncoders.tmobileevaluation.presentation.ui.theme.Black
import com.syncoders.tmobileevaluation.presentation.ui.theme.Orange
import com.syncoders.tmobileevaluation.ui.common_components.CurveHeader
import com.syncoders.tmobileevaluation.ui.screens.auth.intent.AuthIntent
import com.syncoders.tmobileevaluation.ui.screens.profile.view.components.TravelModeCard
import java.util.Calendar
import java.util.Locale


@Composable
fun SearchScreen(parentNavController: NavHostController,
                  dashboardNavController: NavHostController
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val keyboardController = LocalSoftwareKeyboardController.current

    val options = listOf(
        "Car" to painterResource(id = R.drawable.car),
        "Airplane" to painterResource(id = R.drawable.airplane),
        "Bus" to painterResource(id = R.drawable.bus)
    )

    val fromAddress = remember{ mutableStateOf("") }
    val toAddress = remember{mutableStateOf("")}
    val fromDate = remember{ mutableStateOf("") }
    val toDate = remember{mutableStateOf("")}

    var showDatePickerDialog by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val context = LocalContext.current
    val dateFormatter = remember { java.text.SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()) }


    // Start ui design
    Scaffold(
        topBar = {
            CurveHeader("Search Ride")
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues),

                horizontalAlignment = Alignment.Start
            ) {
                // Header Section
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    text = "Plan your travel",
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Black
                    ),
                )
                Spacer(modifier = Modifier.height(16.dp))

                // Transport Icons Row
                TravelModeSelector(
                    options = options,
                    onSelectionChanged = { selectedOption ->
                        println("Selected travel mode: $selectedOption")
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Column(
                    modifier = Modifier.padding(horizontal = 16.dp),
                ){
// Input Fields Section
//                    TravelInputField(label = "From", placeholder = "Lorem, Dolor")
//                    Spacer(modifier = Modifier.height(16.dp))
//                    TravelInputField(label = "Date", placeholder = "DD / MM / YY", isDateField = true)
//
//                    Spacer(modifier = Modifier.height(16.dp))
//
//                    TravelInputField(label = "To", placeholder = "Ipsum, Amet")
//                    Spacer(modifier = Modifier.height(16.dp))
//                    TravelInputField(label = "Date", placeholder = "DD / MM / YY", isDateField = true)
                    Spacer(modifier = Modifier.height(16.dp))
                    AddressTextField(
                        label = "From :",
                        value = fromAddress.value,
                        placeholder = "Enter source here",
                        onValueChange = {
                            fromAddress.value = it
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DateTextField(
                        value = fromDate.value,
                        placeholder = "",
                        onValueChange = {
                            fromDate.value = it
                        },
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    AddressTextField(
                        label = "To :",
                        value = toAddress.value,
                        placeholder = "Enter destination here",
                        onValueChange = {
                            toAddress.value =it
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DateTextField(
                        value = toDate.value,
                        placeholder = "",
                        onValueChange = {
                            toDate.value = it
                        }
                    )

                    Button(
                        onClick = {
                            keyboardController?.hide()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Orange,
                            contentColor = Color.White,
                            disabledContainerColor = Color.LightGray,
                            disabledContentColor = Color.White
                        )
                    ) {
                        Text(
                            text = "Search",
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.W800),
                            modifier = Modifier.padding(horizontal = 36.dp, vertical = 8.dp)
                        )
                    }
                }

            }
        }
        )
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    SearchScreen(parentNavController = rememberNavController(), dashboardNavController = rememberNavController())
}


@Composable
fun TravelModeSelector(
    options: List<Pair<String, Painter>>,
    onSelectionChanged: (String) -> Unit
) {
    var selectedOption by remember { mutableStateOf(options.first().first) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        options.forEach { (label, painter) ->
            TravelModeCard(
                label = label,
                painter = painter,
                isSelected = selectedOption == label, 
                onClick = {
                    selectedOption = label
                    onSelectionChanged(label)
                }
            )
        }
    }
}



@Composable
fun AddressTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Fixed Label
            Icon(
                imageVector = Icons.Default.AddLocation,
                contentDescription = "Location Icon",
                modifier = Modifier.size(24.dp), // Adjusted icon size for better alignment
                tint = Orange
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray,
                    fontSize = 18.sp, // Adjusted font size
                    fontWeight = FontWeight.W500
                ),
                modifier = Modifier.padding(end = 8.dp)
            )

            // Input Field
            TextField(
                value = value,
                onValueChange = onValueChange,
                singleLine = true,
                maxLines = 1,
                placeholder = {
                    Text(
                        text = placeholder,
                        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal) // Adjust placeholder size
                    )
                },
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                textStyle = TextStyle(
                    fontSize = 18.sp, // Increased font size for better visibility
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .weight(1f) // Take remaining space
                    .padding(end = 8.dp), // Adjusted padding
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent, // Transparent background
                    focusedContainerColor = Color.Transparent, // Transparent background
                    focusedIndicatorColor = Color.Transparent, // Hide focused underline
                    unfocusedIndicatorColor = Color.Transparent, // Hide unfocused underline
                    cursorColor = Color.Black // Cursor color
                )
            )
        }

        // Divider with reduced gap
        Divider(
            color = Color.Gray,
            thickness = 1.dp,
            modifier = Modifier.padding(top = 4.dp) // Reduced top padding
        )
    }
}




@Composable
fun DateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String = "",
) {
    var showDatePickerDialog by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val context = LocalContext.current
    val dateFormatter = remember { java.text.SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()) }

    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 0.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Fixed Label Row with Icon and Label
            Row(
                modifier = Modifier
                    .weight(1.0f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.CalendarMonth,
                    contentDescription = "Calendar Icon",
                    modifier = Modifier.size(24.dp),
                    tint = Orange // Orange color
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = "Date:",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.W500
                    ),
                    modifier = Modifier.padding(end = 8.dp)
                )
            }

            // Input Field (non-editable)
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                placeholder = {
                    Text(
                        text = "Choose Date",
                        style = TextStyle(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                singleLine = true,
                readOnly = true,
                enabled = false,
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                textStyle = TextStyle(
                    fontSize = 18.sp,  // Updated to 18.sp
                    fontWeight = FontWeight.Bold  // Bold text
                ),
                modifier = Modifier
                    .weight(1f)
                    .height(56.dp)  // Standard height for TextField
                    .clickable(
                        onClick = {
                            println("Showing datepicker....................")
                            showDatePickerDialog = true
                        }
                    ),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Black,
                    unfocusedIndicatorColor = Color.Black,
                    disabledContainerColor = Color.Transparent,
                    disabledPlaceholderColor = Color.Gray,  // Optional: Gray placeholder when disabled
                    cursorColor = Color.Black
                )
            )

        }

        // Open Date Picker Dialog when clicked
        if (showDatePickerDialog) {
            println("Showing datepicker....................")
            DatePickerDialog(
                dateFormatter = dateFormatter,
                currentDate = calendar,
                onDateSelected = { selectedDate ->
                    onValueChange(selectedDate)
                    showDatePickerDialog = false
                },
                onDismissRequest = { showDatePickerDialog = false } // Close dialog on dismiss
            )
        }
    }
}

@Composable
fun DatePickerDialog(
    dateFormatter: java.text.SimpleDateFormat,
    currentDate: Calendar,
    onDateSelected: (String) -> Unit,
    onDismissRequest: () -> Unit
) {
    val context = LocalContext.current
    val year = currentDate.get(Calendar.YEAR)
    val month = currentDate.get(Calendar.MONTH)
    val day = currentDate.get(Calendar.DAY_OF_MONTH)

    // Show Android's DatePickerDialog
    android.app.DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            val selectedDate = Calendar.getInstance().apply {
                set(selectedYear, selectedMonth, selectedDay)
            }
            onDateSelected(dateFormatter.format(selectedDate.time))
        },
        year,
        month,
        day
    ).apply {
        setOnDismissListener { onDismissRequest() }
        show()
    }
}




@Preview(showBackground = true)
@Composable
fun PreviewDateTextField() {
    var date by remember { mutableStateOf("MM/DD/YYYY") }
    DateTextField(
        value = date,
        onValueChange = { newDate -> date = newDate },
        placeholder = "Select Date"
    )
}




