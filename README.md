Online Course Registration System (SIPENKURS)
A robust web-based application built with Java EE designed to streamline the management of online courses and student enrollments. This project implements the MVC (Model-View-Controller) architectural pattern to ensure a clean separation of concerns and maintainable code.

Key Features
Course Management (CRUD): Full administrative control to Create, Read, Update, and Delete course offerings (including category, duration, pricing, and seat quotas).

Student Enrollment: Seamless integration between student profiles and available courses.

Dynamic Data Rendering: Real-time data fetching from MySQL rendered through JavaServer Pages (JSP).

Responsive UI: Developed with Bootstrap 5 and Bootstrap Icons for a modern, mobile-friendly experience.

Secure Navigation: Robust path handling using request.getContextPath() to prevent broken links across different deployment environments.

Technical Stack
Backend: Java Servlets, DAO (Data Access Object) Pattern.

Frontend: JSP (JavaServer Pages), CSS3, Bootstrap 5.

Database: MySQL / MariaDB (Relational Database Management).

Server: Apache Tomcat 9.0+.

Development Environment: NetBeans IDE / Eclipse.

Database Schema
The system utilizes a relational database named db_kursus_online consisting of:

kursus: Stores course metadata (ID, code, name, category, cost, etc.).

peserta: Stores user/student profiles and credentials.

pendaftaran: A junction table managing the Many-to-Many relationship between students and courses, including payment status.

Installation & Setup
Clone the repository: git clone https://github.com/yourusername/OnlineCourseSystem.git

Database Setup: Import the provided db_kursus_online.sql into your MySQL server.

Configuration: Update your database credentials in the DBConnection.java file.

Deployment:

Open the project in NetBeans.

Run Clean and Build.

Deploy the generated .war file to Apache Tomcat.

Access: Open http://localhost:8080/SistemPendaftaranKursusOnline in your browser.
