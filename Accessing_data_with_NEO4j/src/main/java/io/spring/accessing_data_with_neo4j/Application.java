
package io.spring.accessing_data_with_neo4j;

import java.io.File;
import java.io.IOException;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.io.fs.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.core.GraphDatabase;


@SpringBootApplication
public class Application implements CommandLineRunner{

    
//    ----------------------------------
//    CONFIGURATION CLASS
//    ----------------------------------
    @Configuration
    @EnableNeo4jRepositories(basePackages = "io")
    static class ApplicationConfig extends Neo4jConfiguration {

        public ApplicationConfig() {
            setBasePackage("io");
        }
        
        @Bean
        GraphDatabaseService graphDatabaseService() {
//            creates and reuses a file-based data store at accessingdataneo4j.db.
            return new GraphDatabaseFactory().newEmbeddedDatabase("accessingdataneo4j.db"); 
        }
        
    }
    
//    ---------------------------------
//    END OF CONFIGURATION
//    ---------------------------------
    @Autowired PersonRepository personRepository;
    @Autowired GraphDatabase graphDatabase;
    
    @Override
    public void run(String... strings) throws Exception {
        
        // creating person in memory
        Person greg = new Person("Greg");
        Person roy = new Person("Roy");
        Person craig = new Person("Craig");
        
        
        System.out.println("Before linking up with Neo4j...");
        for (Person person : new Person[] {greg, roy, craig } ) {
            System.out.println(person); //as person.toString()
        }
        
//        To store anything in Neo4j, you must start a transaction using the graphDatabase
        Transaction tx = graphDatabase.beginTx();
        try {
            
            // saving to interface
            personRepository.save(greg);
            personRepository.save(roy);
            personRepository.save(craig);
            
            greg = personRepository.findByName(greg.name);
            greg.worksWith(roy);
            greg.worksWith(craig);
            personRepository.save(greg);
            
            roy = personRepository.findByName(roy.name);
            roy.worksWith(craig);
//          We already know that roy works with greg
            personRepository.save(roy);
            
//          We already know that craig works with roy
            System.out.println("Lookup each person by name...");
            for (String name : new String[] { greg.name, roy.name, craig.name }) {
                System.out.println(personRepository.findByName(name)); // return toString()
            }
            
            System.out.println("Looking up who works with Greg");
            for (Person person : personRepository.findByTeammatesName("Greg")) {
                System.out.println(person.name + " works with Greg.");
            }
            
            tx.success();
            
            
            
        } finally {
            tx.close();
        }

    }
    
    public static void main(String[] args) throws IOException {
        FileUtils.deleteRecursively(new File("accessingdataneo4j.db"));
        SpringApplication.run(Application.class, args);
    }
    
}
