package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe02

data class Program(val id: Int, val name: String, val description: String, val courses: List<Course>)
data class Course(val id: Int, val name: String, val description: String)

val mockCourses = listOf(
    Course(1, "Introduction to Programming", "Learn the basics of programming."),
    Course(2, "Advanced Android Development", "Deep dive into Android app development.")
)
val mockCourses1 = listOf(
    Course(3, "Introduction to AI", "Learn the basics AI and MAchine Learning."),
    Course(4, "Mobile Development", "Deep dive into Android app development.")
)
val mockCourses2 = listOf(
    Course(5, "Networking Fundamentals", "Learn the basics Networking and communication."),
    Course(6, "Software Development", "Learn the aspect of Software development and related projects")
)

val mockPrograms = listOf(
    Program(1, "Computer Science", "Explore computer science.", mockCourses),
    Program(2, "Software Engineering", "Learn about software engineering.", mockCourses2),
    Program(3, "Artificial Intelligence", "Learn about Machine Learning and Real Time Operation.", mockCourses1)
)