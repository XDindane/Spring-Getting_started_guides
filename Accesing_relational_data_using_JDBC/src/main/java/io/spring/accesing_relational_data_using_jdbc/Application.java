package io.spring.accesing_relational_data_using_jdbc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class Application implements CommandLineRunner {
    
    private static final Logger log = LoggerFactory.getLogger(Application.class);
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Spring Boot spots H2, an in-memory relational database engine, and
     * automatically creates a connection. Because we are using spring-jdbc,
     * Spring Boot automatically creates a JdbcTemplate.
     * 
     * The @Autowired JdbcTemplate field automatically loads it and makes it available.
     */
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public void run(String... strings) throws Exception {
        log.info("Creating tables");
        
        jdbcTemplate.execute("DROP TABLE customers IF EXISTS");
        jdbcTemplate.execute("CREATE TABLE customers(id SERIAL, first_name VARCHAR(255), last_name VARCHAR(255))");

        /**
         * Split up the array of whole names into an array of first/last names
         *
         * The first argument to the method call is the query string, the last
         * argument (the array of Object s) holds the variables to be
         * substituted into the query where the “?” characters are.
         */
        // 
        List<Object[]> splitUpNames = Arrays.asList("John Woo", "Jeff Dean", "Josh Bloch", "Josh Long").stream() // Java 8 streams
                .map(name -> name.split(" "))
                .collect(Collectors.toList());
                log.info("b");

        // Use a Java 8 stream to print out each tuple of the list
        splitUpNames.forEach(name -> log.info(String.format("Inserting costumer recrod for %s %s", name[0], name[1])));

        /**
         * Uses JdbcTemplate's batchUpdate operation to bulk load data
         *
         * Note: For single insert statements, JdbcTemplate’s `insert method is
         * good. But for multiple inserts, it’s better to use batchUpdate. Note:
         * Use ? for arguments to avoid SQL injection attacks by instructing
         * JDBC to bind variables.
         */

        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?) ", splitUpNames);

        // SELECTION 
        log.info("Querying for customer records where first_name = 'Josh':");
        jdbcTemplate.query("SELECT id,first_name, last_name FROM customers WHERE first_name = ?", new Object[]{"Josh"}
                , (rs, rowNum) -> new Customer(rs.getLong("id"), rs.getString("first_name"), rs.getString("last_name")))
                .forEach(customer -> log.info(customer.toString()));
        
    }
    
}
