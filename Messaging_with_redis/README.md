## Basic info

This guide walks you through the process of using Spring Data Redis to publish and subscribe to messages sent via Redis.

**url:** http://spring.io/guides/gs/messaging-redis/

**In these example is no folder structure**

**To run. Type in your terminal:** ```mvn spring-boot:run``` or ```mvn clean package``` then ```java -jar target/Messaging_with_redis-1.0-SNAPSHOT.jar```


##Test the service
Additional comments are in source code...

You should see the following output:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v1.2.7.RELEASE)

2014-04-18 08:03:34.032  INFO 47002 --- [           main] hello.Application                        : Starting Application on retina with PID 47002 (/Users/gturnquist/src/spring-guides/gs-messaging-redis/complete/target/classes started by gturnquist)
2014-04-18 08:03:34.062  INFO 47002 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@7a53c84a: startup date [Fri Apr 18 08:03:34 CDT 2014]; root of context hierarchy
2014-04-18 08:03:34.326  INFO 47002 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
2014-04-18 08:03:34.357  INFO 47002 --- [           main] hello.Application                        : Started Application in 0.605 seconds (JVM running for 0.899)
2014-04-18 08:03:34.357  INFO 47002 --- [           main] hello.Application                        : Sending message...
2014-04-18 08:03:34.370  INFO 47002 --- [    container-2] hello.Receiver                           : Received <Hello from Redis!>
2014-04-18 08:03:34.379  INFO 47002 --- [       Thread-1] s.c.a.AnnotationConfigApplicationContext : Closing org.springframework.context.annotation.AnnotationConfigApplicationContext@7a53c84a: startup date [Fri Apr 18 08:03:34 CDT 2014]; root of context hierarchy
2014-04-18 08:03:34.380  INFO 47002 --- [       Thread-1] o.s.c.support.DefaultLifecycleProcessor  : Stopping beans in phase 2147483647

```

