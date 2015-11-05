## Basic info

This guide walks you through the process of creating an application that consumes a RESTful web service.

**url:** http://spring.io/guides/gs/consuming-rest/

**In these example is no folder structure**

**To run. Type in your terminal:** ```mvn spring-boot:run``` or ```mvn clean package``` then ```java -jar target/gs-consuming-rest-0.1.0.jar```


##Output
With project setup complete, you can create a simple application that consumes a RESTful service.

A RESTful service has been stood up at http://gturnquist-quoters.cfapps.io/api/random. It randomly fetches quotes about Spring Boot and returns them as a JSON document.

If you request that URL through your web browser or curl, you’ll receive a JSON document that looks something like this:
 ```{"type":"success","value":{"id":3,"quote":"Spring has come quite a ways in addressing developer enjoyment and ease of use since the last time I built an application using it."}}```

After Implementation you should see the following  output:
```Quote{type='success', value=Value{id=10, quote='Really loving Spring Boot, makes stand alone Spring apps easy.'}}```

