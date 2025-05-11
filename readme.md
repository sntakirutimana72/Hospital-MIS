<p align="center">
  <img width="160" style="border-radius: 50%;" src="docs/logo.png" alt="logo"/>
</p>
<h3 align="center">HOSPITAL INFORMATION MANAGEMENT SYSTEM</h3>
<hr>

This project models a mini version of a **Hospital Information System** with focus on **database design, normalization**, and **Java integration using JDBC**. It simulates real-world hospital operations involving employees, departments, wards, and patients.

---

## 💼 Project Overview

This lab project includes:

- Designing an `ERD` based on hospital structure
- Normalizing the database schema up to 3NF
- Implementing the schema in `PostgresSQL` with relationships and constraints
- Connecting a Java application to the database using `JDBC`
- Performing `CRUD` operations on the Patient entity

---

## 🛠️ Key Features

- 🧱 **Relational Database Design**
  - ER model and schema normalization
  - Primary and foreign key constraints
- 💾 **SQL Implementation**
  - Scripts for table creation and relationships
- 🔗 **Java JDBC Integration**
  - Database connectivity with proper exception handling
- ✍️ **CRUD Operations**
  - Add, read, update, and delete patient records using Java

---
## 🧩 ER Diagram
![ERD](docs/erd.png)

---

## 🧱 Design Pattern: MVC

This application follows the MVC (Model-View-Controller) architecture with a DAO (Data Access Object) layer for persistence.

- Model: Java classes representing entities (e.g., Patient, Employee).

- DAO: Encapsulates database logic (e.g., PatientRepository, EmployeeRepository).

- Controller: Handles user interactions and business logic (e.g., PatientController).

- View: (Optional, depending on interface — CLI).

---

## 📁 Project Structure & Configuration

### 🛠️ Environment Configuration
This project uses **environment variables** for secure and flexible database configuration.
- Environment variables are stored in a `.env.local` file (not committed to version control).
- Managed to use the [`dotenv-java`](https://github.com/cdimascio/dotenv-java) library.
- Example environment variables:
```
DB_URL=jdbc:postgresql://localhost:5432/<YOUR_DB_NAME>
DB_USER=<YOUR_DB_USER>
DB_PASS=<YOUR_DB_PASSWORD>
QUERY_MAX_NUM_PER_PAGE=25
```

N.B: Configuration read from the `.env.local` are automatically available via `com.hospital_mis.config.Env` class.
---

## ⚙️ Technologies Used

![Tools](https://skillicons.dev/icons?i=java,idea,git,github,postgres)

- JDBC
- ERD Modeling Tool ([drawSQL.app](https://drawSQL.app))

---

## 📹 Live Demo

- [Video](https://docs.google.com/document/d/1RQAjtQrLGEYyHtYnFOGqE7rMgEXF9v-m21EgWtXkc04/edit?usp=sharing)
- [Project Guidelines](https://amalitech-training.notion.site/Hospital-Information-System-1ca6c750c0d581ec8baee7e9acebbfff)

---

## 🧑‍💻 How to Run

> Requires Java 17

1. Clone the repository ([link](https://github.com/sntakirutimana72/Hospital-MIS))
2. Setup `postgres` database locally and create a database, then add the `DB NAME` to the `DB_URL` variable in `.env.local`.
3. Create an `.env.local` file inside `src/main/resources/com/hospital_mis/.env.local` to store the DB credentials in Java
4. Run the Java application to perform CRUD operations

---

## Authors

👤 **Steve**
- GitHub: [@sntakirutimana72](https://github.com/sntakirutimana72/)

---

## 🤝 Contributing

Contributions, issues, and feature requests are welcome!

Feel free to check the [issues page](https://github.com/sntakirutimana72/EmployeeMIS/issues/)

---

## Show your support

Give a ⭐️ if you like this project!

---

## Acknowledgments

- Devs Communities for great free and resourceful articles.
