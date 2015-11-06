## Basic info

This guide walks you through the process of accessing relational data with Spring.

**url:** http://spring.io/guides/gs/relational-data-access/

**In these example is no folder structure**

**To run. Type in your terminal:** ```mvn spring-boot:run``` or ```mvn clean package``` then ```java -jar target/Accesing_relational_data_using_JDBC-1.0-SNAPSHOT.jar```


##Output
Addition comments are in source code...

You should see the following output:
```2015-11-06 11:55:47.248  INFO 9598 --- [           main] i.s.a.Application                        : Creating tables
2015-11-06 11:55:47.342  INFO 9598 --- [           main] i.s.a.Application                        : b
2015-11-06 11:55:47.344  INFO 9598 --- [           main] i.s.a.Application                        : Inserting costumer recrod for John Woo
2015-11-06 11:55:47.344  INFO 9598 --- [           main] i.s.a.Application                        : Inserting costumer recrod for Jeff Dean
2015-11-06 11:55:47.344  INFO 9598 --- [           main] i.s.a.Application                        : Inserting costumer recrod for Josh Bloch
2015-11-06 11:55:47.344  INFO 9598 --- [           main] i.s.a.Application                        : Inserting costumer recrod for Josh Long
2015-11-06 11:55:47.360  INFO 9598 --- [           main] i.s.a.Application                        : Querying for customer records where first_name = 'Josh':
2015-11-06 11:55:47.377  INFO 9598 --- [           main] i.s.a.Application                        : Customer[id=3, firstName='Josh', lastName='Bloch']
2015-11-06 11:55:47.377  INFO 9598 --- [           main] i.s.a.Application                        : Customer[id=4, firstName='Josh', lastName='Long']
```

