# 🚀 PROJECT 1 —  **Employee Management System (EMS)** ![Status: Done](https://img.shields.io/badge/Status-Done-green)
---

## 🔥 Key Features

- Create, update, fetch, and delete employees
- DTO ↔ Entity mapping (ModelMapper)
- Input validation using Jakarta Validation
- Global exception handling
- Standardized response structure
- JPA-based repository operations
- PATCH support using ReflectionUtils
- H2/MySQL database configuration

---

## 📌 Tech Stack

- Java 17  
- Spring Boot 3 / 4  
- Spring Web  
- Spring Data JPA  
- ModelMapper  
- H2/MySQL  
- Lombok  

---

## 🧱 API Endpoints
  
`POST /api/employees`  
`GET /api/employees/{id}`  
`PUT /api/employees/{id}`  
`PATCH /api/employees/{id}`  
`DELETE /api/employees/{id}`  

---

## 🏗 Architecture

```
Controller
   ↓
Service
   ↓
Repository
   ↓
Database
```

DTOs and validation act as input layers, while exception handlers ensure clean outputs.

---

## 📘 Learning Outcomes

This project demonstrates your understanding of:

- Clean API design  
- DTO → Entity mapping  
- Validation & error handling  
- Service/repository design patterns  
- Optional handling  
- PATCH operations using reflection  
- MySQL & H2 connectivity  

---

# 🟩 PROJECT 2 — **Workforce Insight & Payroll Analytics System (WIPAS)**  ![Status: In Progress](https://img.shields.io/badge/Status-In%20Progress-blue)
---

This project highlights your ability to work with:

- Complex JPA queries  
- Aggregation functions  
- Pagination & sorting  
- Interface projections  
- @Transactional + @Modifying operations  

---

## 🔥 Key Features

- Employee & department management
- Salary analytics: AVG, SUM, MAX, MIN
- Department-wise insights
- Pagination + sorting for large datasets
- Dynamic filtering of employees
- Projection-based optimized responses
- Transactional salary increments

## 📌 Tech Stack

- Java 17  
- Spring Boot 3 / 4  
- Spring Web  
- Spring Data JPA  
- JPQL + Native Queries  
- Projections  
- Lombok  
- MySQL / PostgreSQL  

---

## 🧱 API Endpoints

### 🔹 Employee APIs

`POST /api/employees`  
`GET /api/employees/{id}`  
`GET /api/employees?page=&size=&sort=`  
`PUT /api/employees/{id}/deactivate`  
`PUT /api/employees/{id}/transfer/{deptId}`  
`PUT /api/employees/increment-salary`

### 🔹 Analytics APIs

`GET /api/analytics/salary/summary`  
`GET /api/analytics/salary/department/{deptId}`  

### 🔹 Projection API

`GET /api/employees/projection/basic`

---

## 🏗 Architecture

```
Controller
   ↓
Service
   ↓
Repository (Custom JPA queries)
   ↓
Database
```

Uses DTO projections + JPA aggregations to keep responses lightweight and efficient.

---

## 🧠 Use Cases will be Solved...

- HR wants to view salary statistics (total payroll, average salary)
- HR wants to increase salary for an entire department
- App needs lightweight projection for mobile view
- Paginated data loading for dashboards
- Transfer employee between departments with rollback if something fails
---

## 📘 Learning Outcomes

This project demonstrates your skills in:

- Pagination & sorting  
- Custom repository queries  
- Aggregation (SUM, AVG, MAX, MIN)  
- Projections (DTO & Interface-based)  
- @Transactional logic  
- Bulk updates with @Modifying  
- Real business logic implementation

# 🟩 Project-3 | Hospital Management ![Status: In Progress](https://img.shields.io/badge/Status-In%20Progress-blue)
## 📌 Tech Stack
`Spring Security`  
`JWT Creation`  
`JWT verification`  
`SignUp and Login`  

### 🔹 APIs

`POST /auth/signup`  
`PSOT /auth/login`  
`GET /api/doctor`  
`GET /api/doctor?id={id}`  
`GET /api/patient?id={id}`  
`GET /api/patient`
