## Quick Start

- This README file was maintenance using [Markdown](https://www.markdownguide.org/basic-syntax/) syntax
- Visual studio code plugin, which can help preview the actual markdown randering and auto generate the table of content
  - `Markdown All in One` by author `Yu Zhang`
  - `Markdown Preview Enhanced` by author `Yiyi Wang`

### Technology stack

- Java 17
- Gradle
- Docker 
- MSSQL
- Spring Boot
- Liquibase

### Steps to setup environment
- Refer Word Java Backend Interivew Assignment

### Clone Project
- `git clone https://github.com/jhanbeh/demo-java-spring-boot.git`

### Import Project
- Open Eclipse > File > Import > Gradle > Existing Gradle Project > Project Cloned

### Gradle
- `./gradlew clean build -x test` to clean and trigger build process. 
- `./gradlew bootRun` to start server.

### Import postman
- Import postman collection via : https://api.postman.com/collections/32312658-fec73ca1-0fde-47c0-a142-f22229910774?access_key=PMAT-01HM2WGVYGXY69B3SNB0277DFB
- If link any issue, refer `Students.postman_collection.json`

#### Create a Java Spring Boot Application.
- Refer Docs.

#### Project Structure is required for ease of maintainability and readability.
- Refer Docs & Workspace.

#### Explore api for Client 
- Refer StudentController.java

#### Each api required to log REQUEST & RESPONSE info into logs file.
- Refer StudentService.java

#### Project connect to database, preferred with MSSQL database (Using Local Machine DB, DB name: TESTDB).
- Refer Docs.

#### Sample for http Methos: INSERT, UPDATE, GET method
- Mock Info `http://localhost:8080/public/v1/test/student`
- Insert Data `http://localhost:8080/public/v1/test/student-registration`
- Retrieve All Students `http://localhost:8080/public/v1/test/student-all`
- Update Students  `http://localhost:8080/public/v1/test/student-update`

#### Explore 1 GET method api with Pagination (Each Page 10 records)
- Retrieve All Studnets with Pageable `http://localhost:8080/public/v1/test/student-page?page=0&size=10`

#### Explore an api which will nested calling another api from 3rd party.
- Retrieve list of movies `http://localhost:8080/public/v1/test/external-api` from public api `https://playground.mockoon.com/movies`

