# Spring Boot, MySQL, Spring Security, JWT, JPA, Rest API


## Steps to Setup

**1. Clone the application**

```bash
git clone 
```

**2. Import Mysql database**
```
data/datatower.sql
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

**4. Import postman collection**
```
data/DataTower.postman_collection.json
```