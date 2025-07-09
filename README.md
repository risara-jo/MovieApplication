# 🎬 Movie Ticket Booking Application

A secure and scalable Spring Boot application for booking movie tickets. Features include user authentication via JWT, role-based access control, MySQL integration, and deployment-ready configuration for platforms like Railway and Render.

---

## 📌 Features

- 🔐 JWT-based User Authentication & Authorization
- 👤 Role-based access control (User/Admin)
- 🎟️ Book movie tickets and select seats
- 🕒 Manage shows and movie schedules
- 🧾 View and manage bookings
- 🛡️ Secure endpoints using Spring Security
- 🐬 MySQL Database Integration
- 🚀 Deployment-ready with Railway & Render compatibility

---

## 🛠️ Tech Stack

| Layer         | Tech                      |
|---------------|---------------------------|
| Language      | Java 21                   |
| Framework     | Spring Boot 3.5.3         |
| Security      | Spring Security + JWT     |
| Database      | MySQL                     |
| ORM           | Spring Data JPA + Hibernate |
| Build Tool    | Maven                     |
| Deployment    | Railway                   |

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/MovieApplication/
│   │   ├── controller/
│   │   ├── entity/
│   │   ├── repository/
│   │   ├── service/
│   │   ├── jwt/
│   │   └── config/
│   └── resources/
│       ├── application.yml
│       └── static/
├── test/
```

---

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/movie-ticket-booking.git
cd movie-ticket-booking
```

### 2. Configure the Database

Update the `application.yml` file:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/movieapp
    username: root
    password: yourpassword
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.MySQL8Dialect

jwt:
  secret: your-secret-key
  expiration: 3600000
```

> ✅ For Railway deployment, replace `localhost` with `mysql.railway.internal` and use Railway’s generated credentials.

### 3. Build and Run

```bash
mvn clean install -DskipTests
mvn spring-boot:run
```

---

## 🔐 Authentication

### Endpoints

- `POST /api/auth/register` – Register new user
- `POST /api/auth/login` – Authenticate and receive JWT
- Include JWT token in the `Authorization` header for all secured endpoints:

```http
Authorization: Bearer <your_token>
```

---

## 🎟️ Booking API Overview

- `GET /api/movie/all`
- `POST /api/booking/createbooking`
- `GET /api/booking/user`
- `GET /api/show/list`
- `POST /api/show/create`

> Full API test collection available in Postman.

---

## 🌐 Deployment

### Railway

- Database: MySQL (auto-provisioned)
- Configure `application.yml` with Railway DB credentials
- Environment variables for `jwt.secret`, etc.
- Deployment done using GitHub repo connect and automatic builds

### Render

- Java Build Command:
  ```
  mvn clean install -DskipTests
  ```
- Start Command:
  ```
  java -jar target/MovieApplication-0.0.1-SNAPSHOT.jar
  ```

---

## 🧪 Testing

```bash
mvn test
```

Includes:
- Unit tests for services
- Integration tests for REST endpoints
- JWT token validation tests

---

## 📂 Sample `.env` for local setup (Optional)

```env
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/movieapp
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=yourpassword
JWT_SECRET=your-secret
```

---

## 🧑‍💻 Author

**Rishara Siriwardhana**  
[LinkedIn](www.linkedin.com/in/rishara-siriwardhana) • [GitHub](https://github.com/risara-jo)

---

## 📄 License

This project is licensed under the MIT License.

---
