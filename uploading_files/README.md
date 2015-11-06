## Basic info

This guide walks you through the process of accessing relational data with Spring.

**url:** http://spring.io/guides/gs/uploading-files/

**In these example is no folder structure**

**To run. Type in your terminal:** ```mvn spring-boot:run``` or ```mvn clean package``` then ```java -jar target/uploading_files-1.0-SNAPSHOT.jar```


##Test the service
Additional comments are in source code...

To test, visit [http://localhost:8080](http://localhost:8080), where you see the upload form and try upload some file

After success upload you should see:
```
You successfully uploaded <name of your file>!
```

The controller itself doesn’t print anything out, but instead returns the message posted to the browser.


