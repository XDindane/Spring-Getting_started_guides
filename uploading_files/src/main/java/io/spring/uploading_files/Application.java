package io.spring.uploading_files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Normally you would add @EnableWebMvc for a Spring MVC app, but Spring Boot
 * adds it automatically when it sees spring-webmvc on the classpath. This flags
 * the application as a web application and activates key behaviors such as
 * setting up a DispatcherServlet.
 * 
 */
@SpringBootApplication
public class Application {

    //The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
