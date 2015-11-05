package spring.consuming_a_restful_ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

/**
 * With project setup complete, you can create a simple application that
 * consumes a RESTful service.
 *
 * A RESTful service has been stood up at
 * @see http://gturnquist-quoters.cfapps.io/api/random. It randomly fetches quotes
 * about Spring Boot and returns them as a JSON document.
 *
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    /**
     * RestTemplate makes interacting with most RESTful services a one-line
     * incantation. And it can even bind that data to custom domain types.
     */
    @Override
    public void run(String... strings) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        //RestTemplate will use it (via a message converter) to convert the incoming JSON data into a Quote object
        Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class); // 
        log.info(quote.toString());
    }

}
