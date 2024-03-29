package com.example.pratheepan_yi_lin_comp304sec003_lab04_exe02

data class Program(val id: Int, val name: String, val description: String, val courses: List<Course>)
data class Course(val id: Int, val name: String, val description: String)

val mockCourses = listOf(
    Course(1, "Introduction to Programming", "Learn the basics of programming."),
    Course(2, "Advanced Android Development", "Deep dive into Android app development.")
)
val mockCourses1 = listOf(
    Course(11, "Introduction to AI", "Learn the basics of AI and Machine Learning, including algorithms, neural networks, and how AI can be applied to solve real-world problems."),
    Course(12, "Mobile Development", "Deep dive into Android app development, covering the Android Studio environment, Kotlin programming, UI design, and application lifecycle."),
    Course(13, "Data Structures and Algorithms", "Explore fundamental data structures like lists, stacks, and trees, along with algorithms for searching, sorting, and optimizing code performance."),
    Course(14, "Software Engineering Principles", "Understand the core principles of software engineering, including design patterns, software testing, version control, and agile development methodologies.")
)

val mockCourses2 = listOf(
    Course(25, "Networking Fundamentals", "Learn the basics of networking and communication, including OSI and TCP/IP models, network topologies, routing and switching, and IP addressing."),
    Course(26, "Software Development", "Explore the aspects of software development including software development life cycles (SDLC), programming methodologies, version control, and project management."),
    Course(27, "Cybersecurity Essentials", "Understand the fundamentals of cybersecurity, focusing on securing digital information, understanding common threats and vulnerabilities, and the basics of encryption and network security."),
    Course(28, "Cloud Computing", "Dive into the world of cloud computing, learning about cloud service models (IaaS, PaaS, SaaS), cloud deployment models, virtualization, and managing cloud resources."),
    Course(29, "User Experience Design", "Learn the principles of user experience design, including user research, design thinking, prototyping, and user testing, to create intuitive and user-friendly digital products."),
    Course(30, "Game Development with Unity", "Explore game development using Unity, covering game physics, animations, AI in games, and mobile game development, culminating in a capstone project.")
)
val mockCoursesIT = listOf(
    Course(15, "IT Support and Operations", "Learn the essentials of IT support, troubleshooting, and operations management."),
    Course(16, "Cloud Infrastructure and Services", "Understand cloud computing technologies, including deployment and service models, cloud security, and managing cloud infrastructure."),
    Course(17, "Network Security", "Dive into the principles of network security, including firewalls, intrusion detection systems, and VPNs."),
    Course(18, "Database Management", "Explore relational databases, SQL, and database design and optimization techniques.")
)
val mockCoursesDataScience = listOf(
    Course(19, "Probability and Statistics for Data Science", "Fundamentals of probability, statistics, and their application in data science."),
    Course(20, "Data Analysis and Visualization", "Techniques for data analysis and visualization using Python."),
    Course(21, "Machine Learning", "An introduction to machine learning concepts and algorithms."),
    Course(22, "Big Data Technologies", "Learn about big data technologies and frameworks for processing large datasets.")
)
val mockCoursesWebDev = listOf(
    Course(23, "HTML and CSS", "Basics of web development with HTML and CSS."),
    Course(24, "JavaScript and Frameworks", "Advanced web development concepts using JavaScript and frameworks like React."),
    Course(225, "Backend Development with Node.js", "Server-side development with Node.js and Express."),
    Course(226, "Web Application Security", "Principles of securing web applications, including common vulnerabilities and their mitigations.")
)
val mockCoursesCybersecurity = listOf(
    Course(27, "Foundations of Cybersecurity", "An overview of cybersecurity principles, best practices, and threat landscape."),
    Course(28, "Ethical Hacking", "Introduction to ethical hacking, tools, and techniques for security testing."),
    Course(29, "Digital Forensics", "Fundamentals of digital forensics, investigation processes, and tools."),
    Course(30, "Cryptography", "Understanding cryptographic principles, algorithms, and their application in securing information.")
)
val mockPrograms = listOf(
    Program(1, "Computer Science", "Explore computer science.", mockCourses),
    Program(2, "Software Engineering", "Learn about software engineering.", mockCourses2),
    Program(3, "Artificial Intelligence", "Learn about Machine Learning and Real Time Operation.", mockCourses1),
    Program(4, "Information Technology", "Dive into the essentials of IT operations and management.", mockCoursesIT),
    Program(5, "Data Science", "Master the skills to analyze and visualize data.", mockCoursesDataScience),
    Program(6, "Web Development", "Build and secure modern web applications.", mockCoursesWebDev),
    Program(7, "Cybersecurity", "Protect digital assets from cyber threats.", mockCoursesCybersecurity)
)