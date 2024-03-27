package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pratheepan_yi_lin_comp304sec003_lab04_exe02.ui.theme.Pratheepan_yi_lin_comp304sec003_lab04_exe02Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pratheepan_yi_lin_comp304sec003_lab04_exe02Theme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "programs") {
        composable("programs") {
            // Assuming `mockPrograms` is your list of programs
            ProgramList(programs = mockPrograms, onProgramSelected = { program ->
                navController.navigate("courses/${program.id}")
            })
        }
        composable("courses/{programId}") { backStackEntry ->
            val programId = backStackEntry.arguments?.getString("programId")?.toInt() ?: return@composable
            val program = mockPrograms.find { it.id == programId }
            program?.let {
                CourseList(courses = it.courses, onCourseSelected = { course ->
                    navController.navigate("courseDescription/${course.id}")
                })
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
    LazyColumn {
        items(programs) { program ->
            // Your existing UI logic, assuming you have Text or some other composable here
            Text(text = program.name, modifier = Modifier.clickable { onProgramSelected(program) })
        }
    }
}

        @Composable
        fun ProgramCard(program: Program) {
            Column {
                Text(
                    text = program.name,
                    style = MaterialTheme.typography.headlineLarge.copy(color = MaterialTheme.colorScheme.secondary)
                )
                Spacer(modifier = Modifier.width(4.dp))
                var isExpanded by remember { mutableStateOf(false) }
                val surfaceColor by animateColorAsState(
                    if (isExpanded) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surface,
                )
                Surface(shape = MaterialTheme.shapes.medium,

                    color = surfaceColor,
                    modifier = Modifier
                        .shadow(elevation = 4.dp) // Apply shadow to mimic elevation
                        .fillMaxSize()
                        .padding(top = 16.dp, end = 16.dp)
                        .clickable { isExpanded = !isExpanded }) {
                    Text(
                        text = program.description,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 15.dp, end = 10.dp, bottom = 16.dp)
                            .animateContentSize(),
                        style = MaterialTheme.typography.labelLarge,
                        color = MaterialTheme.colorScheme.onBackground,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

        @Composable
        fun CourseList(courses: List<Course>, onCourseSelected: (Course) -> Unit) {
            LazyColumn {
                items(courses) { course ->
                    Text(course.name, Modifier.clickable { onCourseSelected(course) })
                    Divider()
                }
            }
        }

        @Composable
        fun CourseDescription(course: Course) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text(course.name, style = MaterialTheme.typography.headlineMedium)
                Text(course.description, style = MaterialTheme.typography.bodyLarge)
            }
        }

@Preview(showBackground = true)
@Composable
fun PreviewProgramCard() {
    // Example courses to include in your programs
    val exampleCourses = listOf(
        Course(1, "Example Course 1", "An example description for Course 1."),
        Course(2, "Example Course 2", "An example description for Course 2.")
    )

    // Updated program instances with all required parameters
    val programs = listOf(
        Program(1, "Sample Program 1", "This is the first sample program.", exampleCourses),
        Program(2, "Sample Program 2", "This is the second sample program.", exampleCourses)
    )

    ProgramList(programs = programs)
}
