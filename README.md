# 🚀 undertow-mongo-service

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-orange?logo=java" />
  <img src="https://img.shields.io/badge/Undertow-Server-blue?logo=undertow" />
  <img src="https://img.shields.io/badge/MongoDB-Database-success?logo=mongodb" />
  <img src="https://img.shields.io/badge/REST-API-green?logo=swagger" />
</p>

---

## 📖 Overview

**undertow-mongo-service** is a **lightweight REST API** built using:
- ⚡ **Undertow** as an embeddable web server  
- 🍃 **MongoDB** as the database  
- 🛠️ A clean modular structure for maintainability  

This project provides basic **CRUD operations** for users and can be easily extended for more endpoints.


---

## 📂 Project Structure

📦 undertow-mongo-service
┣ 📂 src/main/java/com/example/app
┃ ┣ 📂 db
┃ ┃ ┗ MongoConnection.java
┃ ┣ 📂 handlers
┃ ┃ ┗ UserHandler.java
┃ ┣ 📂 routes
┃ ┃ ┗ UserRoutes.java
┃ ┣ 📂 server
┃ ┃ ┣ AppConfig.java
┃ ┃ ┗ ServerApp.java
┃ ┣ 📂 utils
┃ ┃ ┗ JsonUtil.java
┣ pom.xml
┗ README.md


---

## ⚙️ Setup & Run

### 1️⃣ Clone repo

git clone https://github.com/your-username/undertow-mongo-service.git
cd undertow-mongo-service

2️⃣ Configure MongoDB

Update your MongoConnection.java with your Mongo URI:
private static final String CONNECTION_STRING = "mongodb://localhost";

3️⃣ Build with Maven
mvn clean install

4️⃣ Run the server
mvn exec:java -Dexec.mainClass="com.example.app.server.ServerApp"


Server runs at:
👉 http://localhost:8080

📡 API Endpoints
🔹 Get Users
GET /users
Response

[
  { "name": "Alice" },
  { "name": "Bob" }
]

🔹 Create User
POST /users
Content-Type: text/plain

Charlie
Response

{ "name": "Charlie" }

## 📨 Request Flow
sequenceDiagram
    participant Client
    participant Undertow
    participant Handler
    participant MongoDB

    Client->>Undertow: HTTP Request
    Undertow->>Handler: Route matched
    Handler->>MongoDB: Query/Insert
    MongoDB-->>Handler: Response
    Handler-->>Client: JSON Response

## 🤝 Contributing

--Fork it 🍴

--Create a feature branch (git checkout -b feature-name)

--Commit changes (git commit -m 'Add feature')

--Push branch (git push origin feature-name)

--Open a PR 🚀
