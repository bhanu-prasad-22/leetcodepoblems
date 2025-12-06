📘 Spring Boot CRUD Application (In-Memory)

A simple Spring Boot CRUD backend built using a clean 3-layer architecture:

Controller → Service → Repository → In-Memory Store


This project demonstrates how to build a production-style backend without a database, using an in-memory data structure.

🚀 Features

Create Student

Get all Students

Get Student by ID

Update Student

Delete Student

In-Memory Repository (Map + Auto-ID generator)

Proper HTTP Status Codes (200, 201, 204, 404)

Custom Exception Handling

🛠 Tech Stack

Java 17+

Spring Boot 3+

Spring Web

In-memory Repository

Maven

📂 Project Structure
src/main/java/com/example/demo/
 ├── controller/
 │    └── StudentController.java
 ├── service/
 │    └── StudentService.java
 ├── repository/
 │    ├── StudentRepository.java
 │    └── InMemoryStudentRepository.java
 ├── model/
 │    └── Student.java
 ├── exception/
 │    ├── StudentNotFoundException.java
 │    └── RestExceptionHandler.java
 └── DemoApplication.java

▶ Endpoints (Test in Postman)
➤ Get All Students
GET /students

➤ Get Student by ID
GET /students/{id}

➤ Add Student
POST /students
Body:
{
  "name": "Bhanu",
  "age": 20
}

➤ Update Student
PUT /students/{id}
Body:
{
  "name": "Bhanu Updated",
  "age": 21
}

➤ Delete Student
DELETE /students/{id}

💡 How It Works

Controller handles API routes

Service contains business logic

Repository stores data in memory

Exception Handler returns clean error messages

📌 Next Steps

Add H2 / MySQL database

Add DTO + Validation

Add pagination

Connect to a frontend (HTML + Tailwind)
