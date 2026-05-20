# fullstack-student-management-system
Full Stack Student Management System built using React.js, Spring Boot, JPA, and MySQL with CRUD operations and REST API integration.

# Tech Stack
# Frontend
- React.js
- JavaScript
- CSS
- Fetch API

# Backend
- Spring Boot
- Spring Data JPA
- Hibernate
- REST API

# Database
- MySQL

# Features

- Add Student
- View All Students
- Update Student
- Delete Student
- REST API Integration
- Layered Architecture
- Responsive UI
  ## Backend Architecture
- Controller Layer
- Service Layer
- Repository Layer
- Model Layer

# Project Structure
student-management-system
├── backend  
│   ├── controller  
│   ├── service  
│   ├── repository  
│   ├── model  

├── frontend  
│   ├── src  
│   ├── components  

##  API Endpoints

| Method | Endpoint                | Description      |
| ------ | ----------------------- | ---------------- |
| POST   | `/students/add`         | Add Student      |
| GET    | `/students/allStudents` | Get All Students |
| PUT    | `/students/update/{id}` | Update Student   |
| DELETE | `/students/delete/{id}` | Delete Student   |

# How To Run

# Backend
1. Open backend project in Eclipse
2. Configure MySQL database
3. Run Spring Boot application

# Frontend
1. Open frontend project in VS Code
2. Run:

```bash
npm install
npm start
