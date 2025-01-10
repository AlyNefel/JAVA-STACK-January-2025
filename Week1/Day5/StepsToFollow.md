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
     ```

5. **Add Dependencies to `pom.xml`**
   - Copy the following dependencies into your `pom.xml` file:
     ```xml
     <dependencies>
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

## How to Add Code Snippets in STS

To add code snippets in Spring Tool Suite (STS), you can use the following steps:

1. **Open the Preferences Window**
   - Go to `Window` -> `Preferences`.

2. **Navigate to Java -> Editor -> Templates**
   - In the Preferences window, navigate to `Java` -> `Editor` -> `Templates`.

3. **Create a New Template**
   - Click on `New` to create a new template.
   - Provide a name and description for your template.
   - Add the code snippet you want to use in the `Pattern` field.

4. **Use the Template in Your Code**
   - In the editor, type the name of your template and press `Ctrl + Space` to insert the snippet.
