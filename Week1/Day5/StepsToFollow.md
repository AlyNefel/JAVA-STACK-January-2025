## Steps to follow to create a new spring project :P.S : without Data-base dependencies
- Create a new spring boot starter project
- under /src/main we add a new folder named webapp
- inside webapp we create anoter folder named  ```javascript {highlight=3}WEB_INF  (that will hold all our view)
- under src/main/resources in application.properties we add spring.mvc.view.prefix=/WEB_INF/
- copy those dependencies in your pom.xml file : 
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

- right click on the main package / new / package : and name it in this format :  com.mainpackage.controllers
- right click com.mainpackage.controllers : new / class / and name ur main controller 
- add @Controller at the top of your controller name 
- declare your routes using @RequestMapping || @GetMapping || @PostMapping  .. As needed

## How To add code snippet in STS 

