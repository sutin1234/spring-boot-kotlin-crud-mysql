![spring boot kotlin mysql](https://www.callicoder.com/assets/images/post/large/kotlin-spring-boot-restful-web-service.jpg)
# spring-boot-kotlin-crud-Mysql
build spring boot Kotlin CRUD MySQL

#### Prepared Encironment
* Install JDK 8 or more [Download & Install](https://www.oracle.com/java/technologies/javase-downloads.html)
* Install Gradle & Maven [Download & Install](https://mkyong.com/maven/how-to-install-maven-in-windows/)
* Setup Environment for command line using


#### Clone spring boot project
```bash 
$ git clone https://github.com/sutin1234/spring-boot-kotlin-crud-mysql.git proj-name
$ cd proj-name
```

#### Custom mysql configurations
```bash
 #see src/main/resources/application.properties 
 
# MySQL Configurations
spring.datasource.url=jdbc:mysql://localhost:3306/spring_boot?serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.use-new-id-generator-mappings=false
spring.jpa.hibernate.ddl-auto=create

 ```

#### Build & Serve
 ```bash
 $ mvn spring-boot:run 
 $ serve on http://localhost:8080/hotels/all
 ```