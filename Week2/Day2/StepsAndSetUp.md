## Steps to Follow to Create a New Spring Project
**P.S.: Without Database Dependencies**

1. **Create a New Spring Boot Starter Project**
   - Use Spring Initializr or your STS IDE to create a new Spring Boot project.

2. **Add a New Folder Named `webapp`**
   - Under `/src/main`, create a new folder named `webapp`.

3. **Create a Folder Named `WEB_INF`**
   - Inside `webapp`, create another folder named `WEB_INF` (this will hold all your views).

4. **Configure `application.properties`**
   - Under `src/main/resources`, add the following line to `application.properties`:
     ```properties
     spring.mvc.view.prefix=/WEB_INF/
     spring.mvc.view.suffix=.jsp
     logging.level.org.springframework.web.servlet.view=DEBUG
     spring.datasource.url=jdbc:mysql://localhost:3306/databasename
     spring.datasource.username=root
     spring.datasource.password=root
     spring.jpa.hibernate.ddl-auto=update
     spring.mvc.hiddenmethod.filter.enabled=true
     ```

5. **Add Dependencies to `pom.xml`**
   - Copy the following dependencies into your `pom.xml` file:
     ```
         <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-devtools</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>jakarta.servlet.jsp.jstl</groupId>
            <artifactId>jakarta.servlet.jsp.jstl-api</artifactId>
        </dependency>
        <dependency>
            <groupId>org.glassfish.web</groupId>
            <artifactId>jakarta.servlet.jsp.jstl</artifactId>
        </dependency>
        <dependency>
            <groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mindrot</groupId>
            <artifactId>jbcrypt</artifactId>
            <version>0.4</version>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
     </dependencies>
    
     ```

6. **Create a New Package for Controllers**
   - Right-click on the main package, select `New` -> `Package`, and name it in this format: `com.mainpackage.controllers`.

7. **Create a Main Controller Class**
   - Right-click on `com.mainpackage.controllers`, select `New` -> `Class`, and name your main controller.
   - Add `@Controller` at the top of your controller class.
   - Declare your routes using `@RequestMapping`, `@GetMapping`, or `@PostMapping` as needed.

8. **Create a New Package for Models**
  - Right-click on the main package, select `New` -> `Package`, and name it in this format: `com.mainpackage.models`.
  -  Add `@Entity` `@Table(name="nameOFTheModelInPlural"`  annotation to your model class
9. **Create a New Package for Repositories**
  - Right-click on the main package, select `New` -> `Package`, and name it in this format: `com.mainpackage.repositories`. - Inside the `repositories` package, create interfaces, not classes.
  -  Add `@Repository` annotation to your repository interfaces.
10. **Create a New Package for Services**
    - Right-click on the main package, select `New` -> `Package`, and name it in this format: `com.mainpackage.services`.
    - Add `@Service` annotation to your service class.
   

