package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe02.ui.theme.Pratheepan_yi_lin_comp304sec003_lab04_exe02Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pratheepan_yi_lin_comp304sec003_lab04_exe02Theme {
                val lightPurple = Color(0xFF009688)

                Surface(color = lightPurple) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "programs") {
        composable("programs") {

            ProgramList(programs = mockPrograms, onProgramSelected = { program ->
                navController.navigate("courses/${program.id}")
            })
        }
        composable("courses/{programId}") { backStackEntry ->
            val programId = backStackEntry.arguments?.getString("programId")?.toInt() ?: return@composable
            val program = mockPrograms.find { it.id == programId }
            program?.let {
                CourseList(courses = it.courses)
            }
        }
        composable("courseDescription/{courseId}") { backStackEntry ->
            val courseId = backStackEntry.arguments?.getString("courseId")?.toInt() ?: return@composable
            val course = mockPrograms.flatMap { it.courses }.find { it.id == courseId }
            course?.let {
                CourseDescription(course = it)
            }
        }
    }
}
@Composable
fun ProgramList(programs: List<Program>, onProgramSelected: (Program) -> Unit = {}) {
    val textColor = Color(0xFF05221F)
    LazyColumn(modifier = Modifier.padding(3.dp)
        .fillMaxSize()
        .background(Color(0xFF009688))) {
        item{
            Text(
                text = "Centennial College\nProgram List",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Divider(color = Color.White, thickness = 2.dp)
        }
        items(programs) { program ->
            var isProgramExpanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .clickable { isProgramExpanded = !isProgramExpanded }
                    .fillMaxWidth(),

                elevation = CardDefaults.cardElevation()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = program.name, style = MaterialTheme.typography.headlineLarge)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = program.description, style = MaterialTheme.typography.bodyLarge)

                    if (isProgramExpanded) {

                        program.courses.forEach { course ->
                            var isCourseExpanded by remember { mutableStateOf(false) }

                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = course.name,
                                style = MaterialTheme.typography.headlineSmall,
                                modifier = Modifier
                                    .clickable { isCourseExpanded = !isCourseExpanded }
                                    .padding(vertical = 4.dp)
                            )


                            if (isCourseExpanded) {
                                Text(
                                    text = course.description,
                                    style = MaterialTheme.typography.bodyLarge.copy(
                                        color = textColor,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                            }
                        }
                    }
                }
            }
            if (isProgramExpanded) {
                Divider(modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }
}


@Composable
fun CourseList(courses: List<Course>) {
    val textColor = Color(0xFF05221F)
    LazyColumn {
        items(courses) { course ->
            var isExpanded by remember { mutableStateOf(false) }

            Card(
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
                    .fillMaxWidth()
                    .clickable { isExpanded = !isExpanded },
                elevation = CardDefaults.cardElevation()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = course.name, style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(4.dp))

                    if (isExpanded) {
                        Text(
                            text = course.description,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                color = textColor,
                                fontWeight = FontWeight.Bold
                            )
                        )
                    }
                }
            }

            if (isExpanded) {
                Divider()
            }
        }
    }
}
@Composable
fun CourseDescription(course: Course) {

    val textColor = Color(0xFF05221F)

    Column(modifier = Modifier
        .padding(16.dp)
        .fillMaxWidth()) {
        Text(
            text = course.name,
            style = MaterialTheme.typography.headlineSmall.copy(
                color = textColor,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = course.description,
            style = MaterialTheme.typography.bodyLarge.copy(
                color = textColor,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProgramCard() {

    val exampleCourses = listOf(
        Course(1, "Example Course 1", "An example description for Course 1."),
        Course(2, "Example Course 2", "An example description for Course 2.")
    )


    val programs = listOf(
        Program(1, "Sample Program 1", "This is the first sample program.", exampleCourses),
        Program(2, "Sample Program 2", "This is the second sample program.", exampleCourses)
    )

    ProgramList(programs = programs)
}
