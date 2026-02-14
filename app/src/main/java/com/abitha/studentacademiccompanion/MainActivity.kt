package com.abitha.studentacademiccompanion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.abitha.studentacademiccompanion.ui.theme.StudentAcademicCompanionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            StudentAcademicCompanionTheme {

                var screen by remember { mutableStateOf("home") }

                when (screen) {
                    "home" -> HomeScreen(
                        onStudentLogin = { screen = "login" }
                    )

                    "login" -> StudentLoginScreen(
                        onLoginSuccess = { screen = "dashboard" }
                    )

                    "dashboard" -> DashboardScreen()
                }
            }
        }
    }
}