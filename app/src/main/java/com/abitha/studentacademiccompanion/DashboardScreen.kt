package com.abitha.studentacademiccompanion

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DashboardScreen() {

    var selectedTab by remember { mutableStateOf(0) }
    var showAddScreen by remember { mutableStateOf(false) }

    val timetable = remember { mutableStateListOf(
        Pair("Java", "9:00 AM"),
        Pair("Mathematics", "11:00 AM")
    )}

    val assignments = remember { mutableStateListOf(
        Pair("Cybersecurity", "Due 4 July")
    )}

    val exams = remember { mutableStateListOf(
        Pair("Java", "10 July – 10 AM")
    )}

    if (showAddScreen) {
        AddEditScreen(
            titleText = "Add Item",
            subjectValue = "",
            detailValue = "",
            onSave = { s, d ->
                when (selectedTab) {
                    0 -> timetable.add(Pair(s, d))
                    1 -> assignments.add(Pair(s, d))
                    2 -> exams.add(Pair(s, d))
                }
                showAddScreen = false
            },
            onBack = { showAddScreen = false }
        )
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF4F1FA))
            .padding(16.dp)
    ) {

        Text(
            text = "Welcome Abitha 🎓",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        TabRow(selectedTabIndex = selectedTab) {
            Tab(selected = selectedTab == 0, onClick = { selectedTab = 0 }) {
                Text("Timetable", modifier = Modifier.padding(12.dp))
            }
            Tab(selected = selectedTab == 1, onClick = { selectedTab = 1 }) {
                Text("Assignments", modifier = Modifier.padding(12.dp))
            }
            Tab(selected = selectedTab == 2, onClick = { selectedTab = 2 }) {
                Text("Exams", modifier = Modifier.padding(12.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showAddScreen = true }) {
            Text("Add New")
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedTab) {
            0 -> timetable.forEach {
                ItemCard(it.first, it.second,
                    onEdit = {},
                    onDelete = { timetable.remove(it) }
                )
            }

            1 -> assignments.forEach {
                ItemCard(it.first, it.second,
                    onEdit = {},
                    onDelete = { assignments.remove(it) }
                )
            }

            2 -> exams.forEach {
                ItemCard(it.first, it.second,
                    onEdit = {},
                    onDelete = { exams.remove(it) }
                )
            }
        }
    }
}