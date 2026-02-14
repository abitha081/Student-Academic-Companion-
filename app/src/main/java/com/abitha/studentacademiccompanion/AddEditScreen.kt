package com.abitha.studentacademiccompanion

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AddEditScreen(
    titleText: String,
    subjectValue: String,
    detailValue: String,
    onSave: (String, String) -> Unit,
    onBack: () -> Unit
) {
    var subject by remember { mutableStateOf(subjectValue) }
    var detail by remember { mutableStateOf(detailValue) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(titleText, fontSize = 22.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = subject,
            onValueChange = { subject = it },
            label = { Text("Subject Name") },
            textStyle = LocalTextStyle.current.copy(
                color = Color(0xFF5E35B1),
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = detail,
            onValueChange = { detail = it },
            label = { Text("Time / Date") },
            textStyle = LocalTextStyle.current.copy(
                color = Color(0xFF5E35B1),
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { onSave(subject, detail) },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF5E35B1)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save", color = Color.White)
        }

        TextButton(onClick = onBack) {
            Text("Back", color = Color(0xFF5E35B1))
        }
    }
}