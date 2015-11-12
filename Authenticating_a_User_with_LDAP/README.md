## Basic info

This guide walks you through the process creating an application and securing it with the Spring Security LDAP module.

**url:** http://spring.io/guides/gs/authenticating-ldap/

**In these example is no folder structure**

**To run. Type in your terminal:** ```mvn spring-boot:run``` or ```mvn clean package``` then ```java -jar target/Authenticating_a_User_with_LDAP-1.0-SNAPSHOT.jar```


##Test the service
Additional comments are in source code...

To test, visit [http://localhost:8080](http://localhost:8080), where you will be redirected to a login page provided by Spring Security. Enter username **ben** and password **benspassword**. You should see this message in your browser:

```
Welcome to the home page!
```

**Note**: Using an LDIF file isn’t standard configuration for a production system.


