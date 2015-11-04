package maven.spring.scheduling_tasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication //  convenience annotation
@EnableScheduling // ensures that a background task executor is created. Without it, nothing gets scheduled.
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }
}
